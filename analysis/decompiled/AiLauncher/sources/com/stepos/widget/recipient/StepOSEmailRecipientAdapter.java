package com.stepos.widget.recipient;

import La.D;
import La.H;
import Y8.t;
import android.R;
import android.accounts.Account;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.MergeCursor;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.widget.recipient.StepOSCompositeCursorAdapter;
import com.stepos.widget.recipient.StepOSRecipientBaseAdapter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000Ð\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u0000 \u009d\u00012\u00020\u0001:\u000e\u009e\u0001\u009f\u0001 \u0001¡\u0001¢\u0001£\u0001\u009d\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J)\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0013\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u001c\u0010\u001bJ\u0019\u0010\u001f\u001a\u00020\n2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0003¢\u0006\u0004\b\u001f\u0010 J\u001d\u0010#\u001a\b\u0018\u00010\"R\u00020\u00012\u0006\u0010!\u001a\u00020\fH\u0002¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\u0012H\u0002¢\u0006\u0004\b%\u0010\u001bJ\u000f\u0010&\u001a\u00020\u0012H\u0002¢\u0006\u0004\b&\u0010\u001bJ\u0019\u0010(\u001a\u00020\n2\b\u0010'\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b(\u0010)JM\u00101\u001a\u0004\u0018\u00010\u000e2\u0006\u0010+\u001a\u00020*2\u000e\u0010-\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010,2\b\u0010.\u001a\u0004\u0018\u00010\b2\u000e\u0010/\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010,2\b\u00100\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b1\u00102J\u0019\u00104\u001a\u0002032\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0014¢\u0006\u0004\b4\u00105J7\u00109\u001a\u00020\u00122\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u00106\u001a\u0004\u0018\u00010\u000e2\b\u00107\u001a\u0004\u0018\u00010\u000e2\b\u00108\u001a\u0004\u0018\u00010\u000eH\u0014¢\u0006\u0004\b9\u0010:J#\u0010;\u001a\u0004\u0018\u0001032\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\r\u001a\u00020\fH\u0014¢\u0006\u0004\b;\u0010<J+\u0010=\u001a\u00020\u00122\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000eH\u0014¢\u0006\u0004\b=\u0010>J\u001f\u0010A\u001a\u00020\u00122\u0006\u0010?\u001a\u00020\b2\u0006\u0010@\u001a\u00020\bH\u0017¢\u0006\u0004\bA\u0010BJ\u0017\u0010C\u001a\u00020\b2\u0006\u0010?\u001a\u00020\bH\u0016¢\u0006\u0004\bC\u0010\u0017J\u0015\u0010E\u001a\u00020\u00122\u0006\u0010D\u001a\u00020\n¢\u0006\u0004\bE\u0010FJ\u0017\u0010I\u001a\u00020\u00122\b\u0010H\u001a\u0004\u0018\u00010G¢\u0006\u0004\bI\u0010JJ1\u0010O\u001a\u00020N2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010K\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u000e2\u0006\u0010M\u001a\u00020LH\u0014¢\u0006\u0004\bO\u0010PJ\u0017\u0010R\u001a\u00020\u00122\u0006\u0010Q\u001a\u00020\nH\u0004¢\u0006\u0004\bR\u0010FJ)\u0010T\u001a\u00020\u00122\u0006\u0010S\u001a\u00020N2\u0006\u0010K\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u000eH\u0014¢\u0006\u0004\bT\u0010UJ7\u0010W\u001a\u00020N2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010K\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010V\u001a\u00020\u00042\u0006\u0010M\u001a\u00020LH\u0014¢\u0006\u0004\bW\u0010XJ/\u0010Y\u001a\u00020\u00122\u0006\u0010S\u001a\u00020N2\u0006\u0010K\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010V\u001a\u00020\u0004H\u0014¢\u0006\u0004\bY\u0010ZJ\u0017\u0010]\u001a\u00020\u00122\b\u0010\\\u001a\u0004\u0018\u00010[¢\u0006\u0004\b]\u0010^J\u0017\u0010`\u001a\u00020\n2\u0006\u0010_\u001a\u00020\bH\u0016¢\u0006\u0004\b`\u0010)J\u0017\u0010a\u001a\u00020\n2\u0006\u0010_\u001a\u00020\bH\u0016¢\u0006\u0004\ba\u0010)J\u0017\u0010c\u001a\u00020\n2\u0006\u0010b\u001a\u00020\bH\u0016¢\u0006\u0004\bc\u0010)J#\u0010d\u001a\u00020\u00122\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000eH\u0014¢\u0006\u0004\bd\u0010eJ!\u0010f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u001e\u001a\u00020\b2\u0006\u0010Q\u001a\u00020\nH\u0014¢\u0006\u0004\bf\u0010gJ\u000f\u0010h\u001a\u00020\u0012H\u0017¢\u0006\u0004\bh\u0010\u001bJ\u000f\u0010i\u001a\u00020\u0012H\u0017¢\u0006\u0004\bi\u0010\u001bR \u0010l\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020k0j8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bl\u0010mR\u0014\u0010o\u001a\u00020n8\u0004X\u0085\u0004¢\u0006\u0006\n\u0004\bo\u0010pR\u001c\u0010q\u001a\b\u0018\u00010\"R\u00020\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bq\u0010rR\u0016\u0010s\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bs\u0010tR8\u0010w\u001a&\u0012\u0004\u0012\u00020\f\u0012\b\u0012\u00060\"R\u00020\u00010uj\u0012\u0012\u0004\u0012\u00020\f\u0012\b\u0012\u00060\"R\u00020\u0001`v8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bw\u0010xR$\u0010{\u001a\u0012\u0012\u0004\u0012\u00020\b0yj\b\u0012\u0004\u0012\u00020\b`z8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b{\u0010|R\u0016\u0010}\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b}\u0010~R\u0016\u0010\u007f\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u007f\u0010~R\u0018\u0010\u0080\u0001\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0080\u0001\u0010~R\u0016\u0010E\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010~R\u0018\u0010\u0081\u0001\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0081\u0001\u0010~R \u0010\u0083\u0001\u001a\t\u0018\u00010\u0082\u0001R\u00020\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0083\u0001\u0010\u0084\u0001R\u0018\u0010\u0085\u0001\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0085\u0001\u0010tR\u0018\u0010\u0086\u0001\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0086\u0001\u0010~R\u0018\u0010\u0087\u0001\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0087\u0001\u0010~R\u0018\u0010\u0088\u0001\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0088\u0001\u0010~R\u001c\u0010\u008a\u0001\u001a\u0005\u0018\u00010\u0089\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008a\u0001\u0010\u008b\u0001R\u001c\u0010\u008d\u0001\u001a\u0005\u0018\u00010\u008c\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008d\u0001\u0010\u008e\u0001R+\u0010\u0092\u0001\u001a\u0016\u0012\u0005\u0012\u00030\u0090\u00010\u008f\u0001j\n\u0012\u0005\u0012\u00030\u0090\u0001`\u0091\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0092\u0001\u0010\u0093\u0001R\u0017\u0010\u0094\u0001\u001a\u0002038\u0006X\u0087\u0004¢\u0006\b\n\u0006\b\u0094\u0001\u0010\u0095\u0001R\u001d\u0010\u0096\u0001\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u000e\n\u0005\b\u0096\u0001\u0010t\u0012\u0005\b\u0097\u0001\u0010\u001bR\u0017\u0010\u0098\u0001\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0098\u0001\u0010\u0099\u0001R\u0019\u0010\\\u001a\u0004\u0018\u00010[8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\\\u0010\u009a\u0001R\u001b\u0010\u009b\u0001\u001a\u0004\u0018\u00010G8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009b\u0001\u0010\u009c\u0001¨\u0006¤\u0001"}, d2 = {"Lcom/stepos/widget/recipient/StepOSEmailRecipientAdapter;", "Lcom/stepos/widget/recipient/StepOSRecipientBaseAdapter;", "Landroid/content/Context;", "context", "", "inputType", "<init>", "(Landroid/content/Context;I)V", "", "filter", "", "isGlobal", "", "directoryId", "Landroid/database/Cursor;", "onFiltering", "(Ljava/lang/String;ZJ)Landroid/database/Cursor;", "cursor", "LY8/t;", "doEmailMatched", "(Ljava/lang/String;Landroid/database/Cursor;)V", "str", "findChinese", "(Ljava/lang/String;)Ljava/lang/String;", "getGroupData", "(Ljava/lang/String;)Landroid/database/Cursor;", "startGlobalSearch", "()V", "showLoading", "", "constraint", "canGlobalSearch", "(Ljava/lang/CharSequence;)Z", "id", "Lcom/stepos/widget/recipient/StepOSRecipientBaseAdapter$DirectoryPartition;", "getPartitionByDirectoryId", "(J)Lcom/stepos/widget/recipient/StepOSRecipientBaseAdapter$DirectoryPartition;", "cancelLoading", "loadDirectories", "type", "isExchangeType", "(Ljava/lang/String;)Z", "Landroid/net/Uri;", "uri", "", "projection", "selection", "selectionArgs", "sortOrder", "querySafe", "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "", "onDefaultFiltering", "(Ljava/lang/CharSequence;)Ljava/lang/Object;", "groupCursor", "contactCursor", "snsCursor", "onDefaultLoadFinished", "(Ljava/lang/CharSequence;Landroid/database/Cursor;Landroid/database/Cursor;Landroid/database/Cursor;)V", "onDirectoryFiltering", "(Ljava/lang/CharSequence;J)Ljava/lang/Object;", "onDirectoryLoadFinished", "(Ljava/lang/CharSequence;JLandroid/database/Cursor;)V", "phoneOrEmail", "name", "goContactDetail", "(Ljava/lang/String;Ljava/lang/String;)V", "queryDisplayName", "open", "openGlobalAddressBook", "(Z)V", "Lcom/stepos/widget/recipient/StepOSEmailRecipientAdapter$RecipientAdapterEx;", "listener", "setRecipientAdapterEx", "(Lcom/stepos/widget/recipient/StepOSEmailRecipientAdapter$RecipientAdapterEx;)V", "partition", "Landroid/view/ViewGroup;", "parent", "Landroid/view/View;", "newHeaderView", "(Landroid/content/Context;ILandroid/database/Cursor;Landroid/view/ViewGroup;)Landroid/view/View;", "queryByNetwork", "startSnsSearch", "view", "bindHeaderView", "(Landroid/view/View;ILandroid/database/Cursor;)V", "position", "newView", "(Landroid/content/Context;ILandroid/database/Cursor;ILandroid/view/ViewGroup;)Landroid/view/View;", "bindView", "(Landroid/view/View;ILandroid/database/Cursor;I)V", "Landroid/accounts/Account;", "account", "setAccount", "(Landroid/accounts/Account;)V", Const.JSON_KEY_NUMBER, "isSns", "isPhoneNumber", Const.JSON_KEY_ADDRESS, "isEmailAddress", "onSnsLoadFinished", "(Ljava/lang/CharSequence;Landroid/database/Cursor;)V", "onSnsFiltering", "(Ljava/lang/String;Z)Landroid/database/Cursor;", "registerContentObserver", "unregisterContentObserver", "Ljava/util/LinkedHashMap;", "Lcom/stepos/widget/recipient/StepOSContactInfo;", "defaultData", "Ljava/util/LinkedHashMap;", "Landroid/content/ContentResolver;", "mContentResolver", "Landroid/content/ContentResolver;", "preferredDirectory", "Lcom/stepos/widget/recipient/StepOSRecipientBaseAdapter$DirectoryPartition;", "preferredDirectoryIndex", "I", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "directories", "Ljava/util/HashMap;", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "directoryData", "Ljava/util/HashSet;", "globalSearchDelayed", "Z", "onlyGlobal", "autoGlobalSearch", "closeDelayed", "Lcom/stepos/widget/recipient/StepOSRecipientBaseAdapter$SnsPartition;", "snsPartition", "Lcom/stepos/widget/recipient/StepOSRecipientBaseAdapter$SnsPartition;", "snsPartitionIndex", "snsSearch", "snsFirstSearch", "snsLoading", "Landroid/os/Handler;", "contentHandler", "Landroid/os/Handler;", "Landroid/database/ContentObserver;", "directoryObserver", "Landroid/database/ContentObserver;", "Ljava/util/ArrayList;", "Lcom/stepos/widget/recipient/StepOSEmailRecipientAdapter$DirectoryObject;", "Lkotlin/collections/ArrayList;", "directoryList", "Ljava/util/ArrayList;", "mDirectoryLock", "Ljava/lang/Object;", "adapterInputType", "getAdapterInputType$annotations", "appContext", "Landroid/content/Context;", "Landroid/accounts/Account;", "adapterExListener", "Lcom/stepos/widget/recipient/StepOSEmailRecipientAdapter$RecipientAdapterEx;", "Companion", "StepOSEmail", "StepOSDirectory", "RecipientAdapterEx", "DirectoryObject", "RecipientWorker", "DirectoryObserver", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class StepOSEmailRecipientAdapter extends StepOSRecipientBaseAdapter {
    public static final String ACCOUNT_TYPE_AOSP = "com.android.exchange";
    public static final String ACCOUNT_TYPE_GOOGLE = "com.google.android.exchange";
    private static final Pattern CHINESE_PATTERN;
    public static final String CONTACT_ID = "contact_id";
    public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/social_profile";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String DATA1 = "data1";
    public static final Uri DIRECTORIES_NOTIFY_URI;
    private static final int DIRECTORY_ACCOUNT_NAME = 1;
    private static final int DIRECTORY_ACCOUNT_TYPE = 2;
    private static final int DIRECTORY_DISPLAY_NAME = 3;
    private static final int DIRECTORY_ID = 0;
    private static final int DIRECTORY_IS_VISIBLE = 6;
    private static final long DIRECTORY_LOAD_DELAY_MS = 500;
    private static final int DIRECTORY_PACKAGE_NAME = 4;
    private static final String[] DIRECTORY_PROJECTION;
    private static final String DIRECTORY_SELECTION = "_id!=1 AND _id!=0";
    private static final int DIRECTORY_TYPE_RESOURCE_ID = 5;
    public static final Uri EMAILS_FILTER_URI;
    public static final Uri EMAILS_GROUP_URI;
    public static final String EXTRA_INSERT_ACTION = "action";
    public static final Uri GROUPS_SUMMARY_FILTER_URI;
    private static final int LIMIT_COUNT = 20;
    public static final String LOOKUP_KEY = "lookup";
    private static final int MSG_LOAD_DIRECTORY = 4;
    public static final Pattern NAME_ADDR_EMAIL_PATTERN;
    private static final Pattern PHONE;
    public static final Uri SNS_FILTER_URI;
    public static final String SOCIAL_PROFILE = "social_profile";
    public static final Uri SOCIAL_PROFILE_LOOKUP_URI;
    public static final Uri SOCIAL_PROFILE_URI;
    public static final String SUB_TITLE_EXTRA_KEY = "com.android.contacts.extra.SUB_TITLE_EXTRA";
    public static final String SUMMARY_DATA_COUNT = "summary_data_count";
    public static final String TAG = "EmailRecipientAdapter";
    public static final String TITLE_EXTRA_KEY = "com.android.contacts.extra.TITLE_EXTRA";
    private static volatile RecipientWorker contentWorker;
    private Account account;
    private RecipientAdapterEx adapterExListener;
    private final int adapterInputType;
    private final Context appContext;
    private boolean autoGlobalSearch;
    private boolean closeDelayed;
    private Handler contentHandler;
    private final LinkedHashMap<String, StepOSContactInfo> defaultData;
    private final HashMap<Long, StepOSRecipientBaseAdapter.DirectoryPartition> directories;
    private final HashSet<String> directoryData;
    private final ArrayList<DirectoryObject> directoryList;
    private ContentObserver directoryObserver;
    private boolean globalSearchDelayed;
    protected final ContentResolver mContentResolver;
    public final Object mDirectoryLock;
    private boolean onlyGlobal;
    private boolean openGlobalAddressBook;
    private StepOSRecipientBaseAdapter.DirectoryPartition preferredDirectory;
    private int preferredDirectoryIndex;
    private boolean snsFirstSearch;
    private boolean snsLoading;
    private StepOSRecipientBaseAdapter.SnsPartition snsPartition;
    private int snsPartitionIndex;
    private boolean snsSearch;

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0005H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u00020\u001a8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001eX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00050%X\u0082\u0004¢\u0006\u0004\n\u0002\u0010&R\u000e\u0010'\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u001eX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u001eX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u001eX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u001eX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u001eX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u001eX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u001eX\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/stepos/widget/recipient/StepOSEmailRecipientAdapter$Companion;", "", "<init>", "()V", "TAG", "", "ACCOUNT_TYPE_AOSP", "ACCOUNT_TYPE_GOOGLE", "EMAILS_FILTER_URI", "Landroid/net/Uri;", "EMAILS_GROUP_URI", "GROUPS_SUMMARY_FILTER_URI", "SOCIAL_PROFILE_URI", "DIRECTORIES_NOTIFY_URI", "SNS_FILTER_URI", "SOCIAL_PROFILE_LOOKUP_URI", "SUMMARY_DATA_COUNT", "CONTACT_ID", "LOOKUP_KEY", "DATA1", "CONTENT_ITEM_TYPE", "SOCIAL_PROFILE", "SUB_TITLE_EXTRA_KEY", "TITLE_EXTRA_KEY", "EXTRA_INSERT_ACTION", "NAME_ADDR_EMAIL_PATTERN", "Ljava/util/regex/Pattern;", "extractAddrSpec", Const.JSON_KEY_ADDRESS, "LIMIT_COUNT", "", "MSG_LOAD_DIRECTORY", "DIRECTORY_LOAD_DELAY_MS", "", "CHINESE_PATTERN", "PHONE", "DIRECTORY_PROJECTION", "", "[Ljava/lang/String;", "DIRECTORY_SELECTION", "DIRECTORY_ID", "DIRECTORY_ACCOUNT_NAME", "DIRECTORY_ACCOUNT_TYPE", "DIRECTORY_DISPLAY_NAME", "DIRECTORY_PACKAGE_NAME", "DIRECTORY_TYPE_RESOURCE_ID", "DIRECTORY_IS_VISIBLE", "contentWorker", "Lcom/stepos/widget/recipient/StepOSEmailRecipientAdapter$RecipientWorker;", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final String extractAddrSpec(String address) {
            kotlin.jvm.internal.p.i(address, "address");
            Matcher matcher = StepOSEmailRecipientAdapter.NAME_ADDR_EMAIL_PATTERN.matcher(address);
            kotlin.jvm.internal.p.h(matcher, "matcher(...)");
            if (!matcher.matches()) {
                return address;
            }
            String strGroup = matcher.group(2);
            return strGroup == null ? "" : strGroup;
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/stepos/widget/recipient/StepOSEmailRecipientAdapter$DirectoryObject;", "", "<init>", "()V", "directoryId", "", "getDirectoryId", "()J", "setDirectoryId", "(J)V", "directoryType", "", "getDirectoryType", "()Ljava/lang/String;", "setDirectoryType", "(Ljava/lang/String;)V", "displayName", "getDisplayName", "setDisplayName", "accountName", "getAccountName", "setAccountName", "accountType", "getAccountType", "setAccountType", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class DirectoryObject {
        private String accountName;
        private String accountType;
        private long directoryId;
        private String directoryType;
        private String displayName;

        public final String getAccountName() {
            return this.accountName;
        }

        public final String getAccountType() {
            return this.accountType;
        }

        public final long getDirectoryId() {
            return this.directoryId;
        }

        public final String getDirectoryType() {
            return this.directoryType;
        }

        public final String getDisplayName() {
            return this.displayName;
        }

        public final void setAccountName(String str) {
            this.accountName = str;
        }

        public final void setAccountType(String str) {
            this.accountType = str;
        }

        public final void setDirectoryId(long j10) {
            this.directoryId = j10;
        }

        public final void setDirectoryType(String str) {
            this.directoryType = str;
        }

        public final void setDisplayName(String str) {
            this.displayName = str;
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/stepos/widget/recipient/StepOSEmailRecipientAdapter$DirectoryObserver;", "Landroid/database/ContentObserver;", "Landroid/os/Handler;", "handler", "<init>", "(Lcom/stepos/widget/recipient/StepOSEmailRecipientAdapter;Landroid/os/Handler;)V", "", "selfChange", "LY8/t;", "onChange", "(Z)V", "Landroid/os/Handler;", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public final class DirectoryObserver extends ContentObserver {
        private final Handler handler;
        final /* synthetic */ StepOSEmailRecipientAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DirectoryObserver(StepOSEmailRecipientAdapter stepOSEmailRecipientAdapter, Handler handler) {
            super(handler);
            kotlin.jvm.internal.p.i(handler, "handler");
            this.this$0 = stepOSEmailRecipientAdapter;
            this.handler = handler;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean selfChange) {
            this.handler.removeMessages(4);
            this.handler.sendEmptyMessageDelayed(4, 500L);
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J'\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\u000e\u001a\u00020\r2\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000bH&¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/stepos/widget/recipient/StepOSEmailRecipientAdapter$RecipientAdapterEx;", "", "", "filter", "", "colomns", "Landroid/database/Cursor;", "getLocalRecipientData", "(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;", "Ljava/util/ArrayList;", "Lcom/stepos/widget/recipient/StepOSRecipientBaseAdapter$Recipient;", "Lkotlin/collections/ArrayList;", "list", "LY8/t;", "deleteRecommendContact", "(Ljava/util/ArrayList;)V", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface RecipientAdapterEx {
        void deleteRecommendContact(ArrayList<StepOSRecipientBaseAdapter.Recipient> list);

        Cursor getLocalRecipientData(String filter, String[] colomns);
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\n\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\bR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\"\u0010\u0013\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/stepos/widget/recipient/StepOSEmailRecipientAdapter$RecipientWorker;", "Ljava/lang/Runnable;", "", "name", "<init>", "(Ljava/lang/String;)V", "LY8/t;", "run", "()V", "Landroid/os/Looper;", "getLooper", "()Landroid/os/Looper;", "quit", "", "lock", "Ljava/lang/Object;", "looper", "Landroid/os/Looper;", "", "refCount", "I", "getRefCount", "()I", "setRefCount", "(I)V", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class RecipientWorker implements Runnable {
        private final Object lock;
        private Looper looper;
        private int refCount;

        public RecipientWorker(String name) {
            kotlin.jvm.internal.p.i(name, "name");
            Object obj = new Object();
            this.lock = obj;
            new Thread(this, name).start();
            synchronized (obj) {
                while (this.looper == null) {
                    try {
                        Object obj2 = this.lock;
                        kotlin.jvm.internal.p.g(obj2, "null cannot be cast to non-null type java.lang.Object");
                        obj2.wait();
                    } catch (InterruptedException unused) {
                    }
                }
                t tVar = t.f7040a;
            }
        }

        public final Looper getLooper() {
            Looper looper = this.looper;
            if (looper != null) {
                return looper;
            }
            throw new IllegalStateException("RecipientWorker looper is not ready");
        }

        public final int getRefCount() {
            return this.refCount;
        }

        public final void quit() {
            Looper looper = this.looper;
            if (looper != null) {
                looper.quit();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this.lock) {
                Looper.prepare();
                this.looper = Looper.myLooper();
                Object obj = this.lock;
                kotlin.jvm.internal.p.g(obj, "null cannot be cast to non-null type java.lang.Object");
                obj.notifyAll();
                t tVar = t.f7040a;
            }
            Looper.loop();
        }

        public final void setRefCount(int i10) {
            this.refCount = i10;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/stepos/widget/recipient/StepOSEmailRecipientAdapter$StepOSDirectory;", "", "<init>", "()V", "Companion", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class StepOSDirectory {
        public static final Uri AUTHORITY_URI_NOTIFY;
        public static final Uri CONTENT_NOTIFY_URI;
        public static final String IS_VISIBLE = "is_visible";
        public static final long NET_CONTACT = 2;

        static {
            Uri uri = Uri.parse("content://com.android.contacts.notify");
            kotlin.jvm.internal.p.h(uri, "parse(...)");
            AUTHORITY_URI_NOTIFY = uri;
            CONTENT_NOTIFY_URI = StepOSEmailRecipientAdapter.DIRECTORIES_NOTIFY_URI;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/stepos/widget/recipient/StepOSEmailRecipientAdapter$StepOSEmail;", "", "<init>", "()V", "Companion", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class StepOSEmail {
        public static final String USE_CUSTOM_ORDER = "use_custom_order";
        public static final Uri CONTENT_GROUP_URI = StepOSEmailRecipientAdapter.EMAILS_GROUP_URI;
    }

    static {
        Uri uri = Uri.parse("content://com.android.contacts/data/emails/filter/");
        kotlin.jvm.internal.p.h(uri, "parse(...)");
        EMAILS_FILTER_URI = uri;
        Uri uri2 = Uri.parse("content://com.android.contacts/data/emails/group");
        kotlin.jvm.internal.p.h(uri2, "parse(...)");
        EMAILS_GROUP_URI = uri2;
        Uri uri3 = Uri.parse("content://com.android.contacts/groups_summary/filter");
        kotlin.jvm.internal.p.h(uri3, "parse(...)");
        GROUPS_SUMMARY_FILTER_URI = uri3;
        Uri uri4 = Uri.parse("content://com.android.contacts/data/social_profile");
        kotlin.jvm.internal.p.h(uri4, "parse(...)");
        SOCIAL_PROFILE_URI = uri4;
        Uri uri5 = Uri.parse("content://com.android.contacts.notify/directories");
        kotlin.jvm.internal.p.h(uri5, "parse(...)");
        DIRECTORIES_NOTIFY_URI = uri5;
        Uri uri6 = Uri.parse("content://com.stepos.sns/filter/bilateral");
        kotlin.jvm.internal.p.h(uri6, "parse(...)");
        SNS_FILTER_URI = uri6;
        Uri uriWithAppendedPath = Uri.withAppendedPath(uri4, LOOKUP_KEY);
        kotlin.jvm.internal.p.h(uriWithAppendedPath, "withAppendedPath(...)");
        SOCIAL_PROFILE_LOOKUP_URI = uriWithAppendedPath;
        Pattern patternCompile = Pattern.compile("\\s*(\"[^\"]*\"|[^<>\"]+)\\s*<([^<>]+)>\\s*");
        kotlin.jvm.internal.p.h(patternCompile, "compile(...)");
        NAME_ADDR_EMAIL_PATTERN = patternCompile;
        Pattern patternCompile2 = Pattern.compile("([一-龥]+)");
        kotlin.jvm.internal.p.h(patternCompile2, "compile(...)");
        CHINESE_PATTERN = patternCompile2;
        Pattern patternCompile3 = Pattern.compile("(\\+[0-9]+[\\- \\.]*)?(\\([0-9]+\\)[\\- \\.]*)?([0-9][0-9\\- \\.]*)");
        kotlin.jvm.internal.p.h(patternCompile3, "compile(...)");
        PHONE = patternCompile3;
        DIRECTORY_PROJECTION = new String[]{StepOSRecipientEmailHistory._ID, "accountName", "accountType", "displayName", "packageName", "typeResourceId", StepOSDirectory.IS_VISIBLE};
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepOSEmailRecipientAdapter(Context context, int i10) {
        super(context, i10);
        kotlin.jvm.internal.p.i(context, "context");
        this.defaultData = new LinkedHashMap<>();
        ContentResolver contentResolver = context.getContentResolver();
        kotlin.jvm.internal.p.h(contentResolver, "getContentResolver(...)");
        this.mContentResolver = contentResolver;
        this.preferredDirectoryIndex = -1;
        this.directories = new HashMap<>();
        this.directoryData = new HashSet<>();
        this.autoGlobalSearch = i10 == 2;
        this.openGlobalAddressBook = true;
        this.snsPartitionIndex = -1;
        this.directoryList = new ArrayList<>();
        this.mDirectoryLock = new Object();
        this.adapterInputType = i10;
        this.appContext = context;
    }

    @SuppressLint({"MissingPermission"})
    private final boolean canGlobalSearch(CharSequence constraint) {
        HashMap map = new HashMap();
        map.putAll(this.directories);
        this.directories.clear();
        this.directoryData.clear();
        this.preferredDirectory = null;
        this.preferredDirectoryIndex = -1;
        try {
            Object systemService = this.appContext.getSystemService("connectivity");
            ConnectivityManager connectivityManager = systemService instanceof ConnectivityManager ? (ConnectivityManager) systemService : null;
            NetworkCapabilities networkCapabilities = connectivityManager != null ? connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork()) : null;
            if (networkCapabilities != null) {
                if (networkCapabilities.hasCapability(12)) {
                    synchronized (this.mDirectoryLock) {
                        try {
                            Iterator<DirectoryObject> it = this.directoryList.iterator();
                            kotlin.jvm.internal.p.h(it, "iterator(...)");
                            while (it.hasNext()) {
                                DirectoryObject next = it.next();
                                kotlin.jvm.internal.p.h(next, "next(...)");
                                DirectoryObject directoryObject = next;
                                long directoryId = directoryObject.getDirectoryId();
                                StepOSRecipientBaseAdapter.DirectoryPartition partitionByDirectoryId = getPartitionByDirectoryId(directoryId);
                                if (partitionByDirectoryId == null) {
                                    partitionByDirectoryId = (StepOSRecipientBaseAdapter.DirectoryPartition) map.get(Long.valueOf(directoryId));
                                }
                                if (partitionByDirectoryId == null) {
                                    partitionByDirectoryId = new StepOSRecipientBaseAdapter.DirectoryPartition();
                                }
                                partitionByDirectoryId.setDirectoryId(directoryId);
                                partitionByDirectoryId.setConstraint(constraint);
                                partitionByDirectoryId.setDisplayName(directoryObject.getDisplayName());
                                partitionByDirectoryId.setAccountName(directoryObject.getAccountName());
                                partitionByDirectoryId.setAccountType(directoryObject.getAccountType());
                                partitionByDirectoryId.setDirectoryType(directoryObject.getDirectoryType());
                                Account account = this.account;
                                if (account != null && kotlin.jvm.internal.p.d(account.name, partitionByDirectoryId.getAccountName()) && kotlin.jvm.internal.p.d(account.type, partitionByDirectoryId.getAccountType())) {
                                    this.preferredDirectory = partitionByDirectoryId;
                                }
                                this.directories.put(Long.valueOf(directoryId), partitionByDirectoryId);
                            }
                            t tVar = t.f7040a;
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    if (this.directories.isEmpty()) {
                        Log.d(TAG, "canGlobalSearch--mDirectories.size() == 0:" + this.adapterInputType);
                        return false;
                    }
                    Log.d(TAG, "canGlobalSearch--mDirectories.size() > 0:" + this.adapterInputType);
                    return true;
                }
            }
        } catch (SecurityException unused) {
        }
        return false;
    }

    private final void cancelLoading() {
        if (getSize() > 0 && (getPartition(getSize() - 1) instanceof StepOSRecipientBaseAdapter.FlagPartition)) {
            Log.d(TAG, "cancelLoading--if:" + this.adapterInputType);
            removePartition(getSize() + (-1));
        }
        Log.d(TAG, "cancelLoading--else:" + this.adapterInputType);
    }

    private final void doEmailMatched(String filter, Cursor cursor) {
        String strSubstring;
        if (cursor != null && cursor.getCount() > 0) {
            int iT0 = H.t0(filter, '@', 0, false, 6, null);
            if (iT0 < 0) {
                strSubstring = filter;
            } else {
                strSubstring = filter.substring(0, iT0);
                kotlin.jvm.internal.p.h(strSubstring, "substring(...)");
            }
            cursor.moveToPosition(-1);
            while (cursor.moveToNext()) {
                String string = cursor.getString(1);
                String strSubstring2 = string == null ? "" : string;
                int iT02 = H.t0(strSubstring2, '@', 0, false, 6, null);
                if (iT02 >= 0) {
                    strSubstring2 = strSubstring2.substring(0, iT02);
                    kotlin.jvm.internal.p.h(strSubstring2, "substring(...)");
                }
                if (kotlin.jvm.internal.p.d(strSubstring2, strSubstring)) {
                    StepOSContactInfo stepOSContactInfo = new StepOSContactInfo();
                    String string2 = cursor.getString(0);
                    if (string2 == null) {
                        string2 = "";
                    }
                    String string3 = cursor.getString(2);
                    if (string3 == null) {
                        string3 = "";
                    }
                    stepOSContactInfo.setContactInfo(string2, string3, cursor.getLong(3));
                    LinkedHashMap<String, StepOSContactInfo> linkedHashMap = this.defaultData;
                    String string4 = cursor.getString(1);
                    linkedHashMap.put(string4 != null ? string4 : "", stepOSContactInfo);
                }
            }
        }
        Log.d(TAG, "doEmailMatched:" + this.adapterInputType);
    }

    public static final String extractAddrSpec(String str) {
        return INSTANCE.extractAddrSpec(str);
    }

    private final String findChinese(String str) {
        Matcher matcher = CHINESE_PATTERN.matcher(str);
        kotlin.jvm.internal.p.h(matcher, "matcher(...)");
        String strGroup = matcher.find() ? matcher.group() : null;
        Log.d(TAG, "findChinese:" + this.adapterInputType);
        return !TextUtils.isEmpty(strGroup) ? strGroup == null ? "" : strGroup : str;
    }

    private static /* synthetic */ void getAdapterInputType$annotations() {
    }

    private final Cursor getGroupData(String filter) {
        Uri uriWithAppendedPath = Uri.withAppendedPath(GROUPS_SUMMARY_FILTER_URI, Uri.encode(filter));
        kotlin.jvm.internal.p.h(uriWithAppendedPath, "withAppendedPath(...)");
        Uri uriBuild = uriWithAppendedPath.buildUpon().appendQueryParameter("mimetype", "vnd.android.cursor.item/email_v2").build();
        String[] strArr = {"title", SUMMARY_DATA_COUNT, StepOSRecipientEmailHistory._ID};
        Cursor cursorQuerySafe = querySafe(uriBuild, strArr, null, null, null);
        if (cursorQuerySafe != null) {
            try {
                if (cursorQuerySafe.getCount() > 0) {
                    MatrixCursor matrixCursor = new MatrixCursor(strArr);
                    cursorQuerySafe.moveToPosition(-1);
                    while (cursorQuerySafe.moveToNext()) {
                        if (cursorQuerySafe.getInt(1) > 0) {
                            MatrixCursor.RowBuilder rowBuilderNewRow = matrixCursor.newRow();
                            kotlin.jvm.internal.p.h(rowBuilderNewRow, "newRow(...)");
                            for (int i10 = 0; i10 < 3; i10++) {
                                String str = strArr[i10];
                                int iHashCode = str.hashCode();
                                if (iHashCode != -2020522381) {
                                    if (iHashCode != 94650) {
                                        if (iHashCode == 110371416 && str.equals("title")) {
                                            rowBuilderNewRow.add(cursorQuerySafe.getString(0));
                                        }
                                    } else if (str.equals(StepOSRecipientEmailHistory._ID)) {
                                        rowBuilderNewRow.add(Long.valueOf(cursorQuerySafe.getLong(2)));
                                    }
                                } else if (str.equals(SUMMARY_DATA_COUNT)) {
                                    rowBuilderNewRow.add(Integer.valueOf(cursorQuerySafe.getInt(1)));
                                }
                            }
                        }
                    }
                    Log.d(TAG, "getGroupData-newCursor:" + this.adapterInputType);
                    cursorQuerySafe.close();
                    return matrixCursor;
                }
            } finally {
            }
        }
        Log.d(TAG, "getGroupData-null:" + this.adapterInputType);
        if (cursorQuerySafe != null) {
            cursorQuerySafe.close();
        }
        return null;
    }

    private final StepOSRecipientBaseAdapter.DirectoryPartition getPartitionByDirectoryId(long id) {
        int size = getSize();
        for (int i10 = 0; i10 < size; i10++) {
            StepOSCompositeCursorAdapter.Partition partition = getPartition(i10);
            if (partition instanceof StepOSRecipientBaseAdapter.DirectoryPartition) {
                StepOSRecipientBaseAdapter.DirectoryPartition directoryPartition = (StepOSRecipientBaseAdapter.DirectoryPartition) partition;
                if (directoryPartition.getDirectoryId() == id) {
                    return directoryPartition;
                }
            }
        }
        return null;
    }

    private final boolean isExchangeType(String type) {
        return kotlin.jvm.internal.p.d(ACCOUNT_TYPE_AOSP, type) || kotlin.jvm.internal.p.d(ACCOUNT_TYPE_GOOGLE, type);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadDirectories() {
        this.directoryList.clear();
        Uri CONTENT_URI = ContactsContract.Directory.CONTENT_URI;
        kotlin.jvm.internal.p.h(CONTENT_URI, "CONTENT_URI");
        Cursor cursorQuerySafe = querySafe(CONTENT_URI, DIRECTORY_PROJECTION, DIRECTORY_SELECTION, null, null);
        if (cursorQuerySafe != null) {
            try {
                if (cursorQuerySafe.getCount() > 0) {
                    PackageManager packageManager = getAppContext().getPackageManager();
                    kotlin.jvm.internal.p.h(packageManager, "getPackageManager(...)");
                    cursorQuerySafe.moveToPosition(-1);
                    while (cursorQuerySafe.moveToNext()) {
                        if (cursorQuerySafe.getInt(6) == 1 && isExchangeType(cursorQuerySafe.getString(2))) {
                            DirectoryObject directoryObject = new DirectoryObject();
                            directoryObject.setDirectoryId(cursorQuerySafe.getLong(0));
                            directoryObject.setDisplayName(cursorQuerySafe.getString(3));
                            directoryObject.setAccountName(cursorQuerySafe.getString(1));
                            directoryObject.setAccountType(cursorQuerySafe.getString(2));
                            String string = cursorQuerySafe.getString(4);
                            int i10 = cursorQuerySafe.getInt(5);
                            if (string != null && i10 != 0) {
                                try {
                                    Resources resourcesForApplication = packageManager.getResourcesForApplication(string);
                                    kotlin.jvm.internal.p.h(resourcesForApplication, "getResourcesForApplication(...)");
                                    directoryObject.setDirectoryType(resourcesForApplication.getString(i10));
                                    if (directoryObject.getDirectoryType() == null) {
                                        Log.e(TAG, "Cannot resolve directory name: " + i10 + "@" + string);
                                    }
                                } catch (PackageManager.NameNotFoundException e10) {
                                    Log.e(TAG, "Cannot resolve directory name: " + i10 + "@" + string, e10);
                                }
                            }
                            this.directoryList.add(directoryObject);
                        }
                    }
                }
            } finally {
                cursorQuerySafe.close();
            }
        }
        if (cursorQuerySafe != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void newHeaderView$lambda$1(StepOSEmailRecipientAdapter stepOSEmailRecipientAdapter, View view) {
        if (stepOSEmailRecipientAdapter.snsSearch) {
            stepOSEmailRecipientAdapter.snsLoading = true;
            stepOSEmailRecipientAdapter.startSnsSearch(true ^ stepOSEmailRecipientAdapter.snsFirstSearch);
            stepOSEmailRecipientAdapter.notifyDataSetChanged();
        } else {
            stepOSEmailRecipientAdapter.globalSearchDelayed = false;
            stepOSEmailRecipientAdapter.startGlobalSearch();
            stepOSEmailRecipientAdapter.notifyDataSetChanged();
        }
    }

    private final Cursor onFiltering(String filter, boolean isGlobal, long directoryId) throws IOException {
        String strSubstring;
        String strSubstring2;
        String strFindChinese = findChinese(filter);
        Uri uriBuild = EMAILS_FILTER_URI.buildUpon().appendPath(strFindChinese).appendQueryParameter(StepOSEmail.USE_CUSTOM_ORDER, "true").appendQueryParameter("remove_duplicate_entries", "true").build();
        kotlin.jvm.internal.p.h(uriBuild, "build(...)");
        if (isGlobal) {
            uriBuild = uriBuild.buildUpon().appendQueryParameter("directory", String.valueOf(directoryId)).appendQueryParameter("limit", "20").build();
        }
        Cursor cursorQuerySafe = querySafe(uriBuild, StepOSRecipientBaseAdapter.PROJECTION, null, null, "sort_key");
        if (isGlobal) {
            Log.d(TAG, "onFiltering:" + this.adapterInputType);
            return cursorQuerySafe;
        }
        doEmailMatched(strFindChinese, cursorQuerySafe);
        String[] strArr = {StepOSRecipientEmailHistory.DISPLAY_NAME, "email"};
        RecipientAdapterEx recipientAdapterEx = this.adapterExListener;
        Cursor localRecipientData = recipientAdapterEx != null ? recipientAdapterEx.getLocalRecipientData(strFindChinese, strArr) : null;
        if (cursorQuerySafe != null) {
            cursorQuerySafe.moveToPosition(-1);
            while (cursorQuerySafe.moveToNext()) {
                StepOSContactInfo stepOSContactInfo = new StepOSContactInfo();
                String string = cursorQuerySafe.getString(0);
                if (string == null) {
                    string = "";
                }
                String string2 = cursorQuerySafe.getString(2);
                if (string2 == null) {
                    string2 = "";
                }
                stepOSContactInfo.setContactInfo(string, string2, cursorQuerySafe.getLong(3));
                LinkedHashMap<String, StepOSContactInfo> linkedHashMap = this.defaultData;
                String string3 = cursorQuerySafe.getString(1);
                if (string3 == null) {
                    string3 = "";
                }
                linkedHashMap.put(string3, stepOSContactInfo);
            }
            cursorQuerySafe.close();
        }
        int iT0 = H.t0(strFindChinese, '@', 0, false, 6, null);
        String str = "substring(...)";
        if (iT0 < 0) {
            strSubstring = strFindChinese;
        } else {
            strSubstring = strFindChinese.substring(0, iT0);
            kotlin.jvm.internal.p.h(strSubstring, "substring(...)");
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        String[] strArr2 = {"data"};
        MatrixCursor matrixCursor = new MatrixCursor(strArr2);
        MatrixCursor matrixCursor2 = new MatrixCursor(strArr2);
        if (localRecipientData != null) {
            localRecipientData.moveToPosition(-1);
            while (localRecipientData.moveToNext()) {
                byte[] blob = localRecipientData.getBlob(0);
                ArrayList<StepOSRecipientBaseAdapter.Recipient> arrayListDataToRecipientList = StepOSRecipientBaseAdapter.Recipient.INSTANCE.dataToRecipientList(blob);
                if (arrayListDataToRecipientList.size() == 1) {
                    StepOSContactInfo stepOSContactInfo2 = new StepOSContactInfo();
                    String mDisplayName = arrayListDataToRecipientList.get(0).getMDisplayName();
                    String mAddress = arrayListDataToRecipientList.get(0).getMAddress();
                    int iT02 = H.t0(mAddress, '@', 0, false, 6, null);
                    if (iT02 < 0) {
                        strSubstring2 = mAddress;
                    } else {
                        strSubstring2 = mAddress.substring(0, iT02);
                        kotlin.jvm.internal.p.h(strSubstring2, str);
                    }
                    if (kotlin.jvm.internal.p.d(strSubstring2, strSubstring)) {
                        matrixCursor.addRow(new Object[]{blob});
                    } else {
                        matrixCursor2.addRow(new Object[]{blob});
                    }
                    StepOSContactInfo stepOSContactInfo3 = this.defaultData.get(mAddress);
                    if (stepOSContactInfo3 != null) {
                        contactId = D.L(mDisplayName, stepOSContactInfo3.getContactName(), true) ? stepOSContactInfo3.getContactId() : 0L;
                        this.defaultData.remove(mAddress);
                    }
                    stepOSContactInfo2.setContactInfo(mDisplayName, "", contactId);
                    linkedHashMap2.put(mAddress, stepOSContactInfo2);
                    str = str;
                } else {
                    matrixCursor2.addRow(new Object[]{blob});
                }
            }
            localRecipientData.close();
        }
        MatrixCursor matrixCursor3 = new MatrixCursor(StepOSRecipientBaseAdapter.PROJECTION);
        for (Map.Entry<String, StepOSContactInfo> entry : this.defaultData.entrySet()) {
            String key = entry.getKey();
            StepOSContactInfo value = entry.getValue();
            MatrixCursor.RowBuilder rowBuilderNewRow = matrixCursor3.newRow();
            kotlin.jvm.internal.p.h(rowBuilderNewRow, "newRow(...)");
            rowBuilderNewRow.add(value.getContactName());
            rowBuilderNewRow.add(key);
            rowBuilderNewRow.add(value.getContactCompany());
            rowBuilderNewRow.add(Long.valueOf(value.getContactId()));
        }
        this.defaultData.putAll(linkedHashMap2);
        linkedHashMap2.clear();
        return this.adapterExListener != null ? new MergeCursor(new MatrixCursor[]{matrixCursor, matrixCursor2, matrixCursor3}) : matrixCursor3;
    }

    private final Cursor querySafe(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        try {
            return this.mContentResolver.query(uri, projection, selection, selectionArgs, sortOrder);
        } catch (IllegalArgumentException e10) {
            Log.w(TAG, "query invalid: " + uri, e10);
            return null;
        } catch (SecurityException e11) {
            Log.w(TAG, "query denied: " + uri, e11);
            return null;
        } catch (Exception e12) {
            Log.w(TAG, "query failed: " + uri, e12);
            return null;
        }
    }

    private final void showLoading() {
        if (getSize() <= 0 || !(getPartition(getSize() - 1) instanceof StepOSRecipientBaseAdapter.FlagPartition)) {
            addPartition(new StepOSRecipientBaseAdapter.FlagPartition());
            changeCursor(getSize() - 1, null);
            Log.d(TAG, "showLoading:" + this.adapterInputType);
        }
    }

    private final void startGlobalSearch() {
        if (!this.directories.isEmpty()) {
            setNotificationsEnabled(false);
            showLoading();
            setNotificationsEnabled(true);
            for (StepOSRecipientBaseAdapter.DirectoryPartition directoryPartition : this.directories.values()) {
                kotlin.jvm.internal.p.h(directoryPartition, "next(...)");
                StepOSRecipientBaseAdapter.DirectoryPartition directoryPartition2 = directoryPartition;
                StepOSRecipientBaseAdapter.DirectoryPartitionFilter filter = directoryPartition2.getFilter();
                if (filter == null) {
                    filter = new StepOSRecipientBaseAdapter.DirectoryPartitionFilter(-1, directoryPartition2.getDirectoryId());
                    directoryPartition2.setFilter(filter);
                }
                filter.filter(directoryPartition2.getConstraint());
            }
        }
        Log.d(TAG, "startGlobalSearch:" + this.adapterInputType);
    }

    @Override // com.stepos.widget.recipient.StepOSCompositeCursorAdapter
    public void bindHeaderView(View view, int partition, Cursor cursor) {
        kotlin.jvm.internal.p.i(view, "view");
        View viewFindViewById = view.findViewById(R.id.text1);
        kotlin.jvm.internal.p.h(viewFindViewById, "findViewById(...)");
        TextView textView = (TextView) viewFindViewById;
        if (this.snsSearch) {
            if (this.snsFirstSearch) {
                if (this.snsLoading) {
                    view.setEnabled(false);
                    textView.setText(com.stepos.widget.R.string.stepos_recipient_sns_searching);
                    return;
                } else {
                    view.setEnabled(true);
                    textView.setText(com.stepos.widget.R.string.stepos_recipient_sns_search);
                    return;
                }
            }
            if (this.snsLoading) {
                view.setEnabled(false);
                textView.setText(com.stepos.widget.R.string.stepos_recipient_sns_searching);
                return;
            } else {
                view.setEnabled(true);
                textView.setText(com.stepos.widget.R.string.stepos_recipient_sns_search);
                return;
            }
        }
        if (this.globalSearchDelayed) {
            Log.d(TAG, "bindHeaderView--mGlobalSearchDelayed:" + this.adapterInputType);
            view.setEnabled(true);
            textView.setText(com.stepos.widget.R.string.stepos_recipient_global_search);
            return;
        }
        Log.d(TAG, "bindHeaderView:" + this.adapterInputType);
        view.setEnabled(false);
        textView.setText(com.stepos.widget.R.string.stepos_recipient_global_searching);
    }

    @Override // com.stepos.widget.recipient.StepOSCompositeCursorAdapter
    public void bindView(View view, int partition, Cursor cursor, int position) throws IOException, NumberFormatException {
        boolean z10;
        String string;
        String str;
        String string2;
        String string3;
        kotlin.jvm.internal.p.i(view, "view");
        kotlin.jvm.internal.p.i(cursor, "cursor");
        View viewFindViewById = view.findViewById(R.id.text1);
        kotlin.jvm.internal.p.h(viewFindViewById, "findViewById(...)");
        TextView textView = (TextView) viewFindViewById;
        textView.setHorizontallyScrolling(false);
        View viewFindViewById2 = view.findViewById(R.id.icon);
        kotlin.jvm.internal.p.h(viewFindViewById2, "findViewById(...)");
        ImageView imageView = (ImageView) viewFindViewById2;
        imageView.setVisibility(8);
        if (cursor.getColumnCount() == 1) {
            ArrayList<StepOSRecipientBaseAdapter.Recipient> arrayListDataToRecipientList = StepOSRecipientBaseAdapter.Recipient.INSTANCE.dataToRecipientList(cursor.getBlob(0));
            if (arrayListDataToRecipientList.size() == 1) {
                string3 = arrayListDataToRecipientList.get(0).getMDisplayName();
                string = arrayListDataToRecipientList.get(0).getMAddress();
                z10 = false;
                string2 = string3;
                str = "";
            } else {
                imageView.setImageResource(com.stepos.widget.R.drawable.stepos_icon_recipient_delete);
                imageView.setVisibility(0);
                StringBuilder sb2 = new StringBuilder();
                Iterator<StepOSRecipientBaseAdapter.Recipient> it = arrayListDataToRecipientList.iterator();
                kotlin.jvm.internal.p.h(it, "iterator(...)");
                while (it.hasNext()) {
                    StepOSRecipientBaseAdapter.Recipient next = it.next();
                    kotlin.jvm.internal.p.h(next, "next(...)");
                    sb2.append(next.getMDisplayName());
                    sb2.append(' ');
                }
                string = "";
                z10 = true;
                string2 = sb2.toString();
                str = string;
            }
        } else if (cursor.getColumnCount() == 2) {
            string3 = cursor.getString(0);
            if (string3 == null) {
                string3 = "";
            }
            string = cursor.getString(1);
            if (string == null) {
                string = "";
            }
            z10 = false;
            string2 = string3;
            str = "";
        } else if (cursor.getColumnCount() > 2) {
            String string4 = cursor.getString(0);
            if (string4 == null) {
                string4 = "";
            }
            String string5 = cursor.getString(1);
            if (string5 == null) {
                string5 = "";
            }
            String string6 = cursor.getString(2);
            if (string6 == null) {
                string6 = "";
            }
            String str2 = string4;
            str = string6;
            string = string5;
            string2 = str2;
            z10 = false;
        } else {
            z10 = false;
            string = "";
            str = string;
            string2 = str;
        }
        textView.setText(string2);
        View viewFindViewById3 = view.findViewById(R.id.text2);
        kotlin.jvm.internal.p.h(viewFindViewById3, "findViewById(...)");
        TextView textView2 = (TextView) viewFindViewById3;
        textView2.setHorizontallyScrolling(false);
        textView2.setVisibility(0);
        StepOSCompositeCursorAdapter.Partition partition2 = getPartition(partition);
        if (partition == 0 && (partition2 instanceof StepOSRecipientBaseAdapter.GroupPartition)) {
            try {
                textView2.setText(this.appContext.getString(com.stepos.widget.R.string.stepos_recipient_total, Integer.valueOf(Integer.parseInt(string))));
                t tVar = t.f7040a;
            } catch (NumberFormatException unused) {
                Log.d(TAG, "error");
            }
        } else {
            if (!TextUtils.isEmpty(str)) {
                string = string + " " + str;
            }
            if (TextUtils.isEmpty(string2)) {
                textView.setText(string);
                textView2.setText("");
                textView2.setVisibility(8);
            } else if (z10) {
                textView2.setText("");
                textView2.setVisibility(8);
            } else {
                textView2.setText(string);
            }
            if (partition2 instanceof StepOSRecipientBaseAdapter.DirectoryPartition) {
                imageView.setVisibility(0);
                imageView.setImageResource(com.stepos.widget.R.drawable.stepos_icon_recipient_global);
            } else if (partition2 instanceof StepOSRecipientBaseAdapter.SnsPartition) {
                imageView.setVisibility(0);
                imageView.setImageResource(com.stepos.widget.R.drawable.stepos_icon_recipient_sns);
            }
        }
        Log.d(TAG, "bindView:" + this.adapterInputType);
    }

    @Override // com.stepos.widget.recipient.StepOSRecipientBaseAdapter
    public void goContactDetail(String phoneOrEmail, String name) {
        Cursor cursorQuerySafe;
        int i10;
        Intent type;
        kotlin.jvm.internal.p.i(phoneOrEmail, "phoneOrEmail");
        kotlin.jvm.internal.p.i(name, "name");
        Uri lookupUri = null;
        if ((this.adapterInputType & 4) == 4) {
            Uri uriWithAppendedPath = Uri.withAppendedPath(SOCIAL_PROFILE_LOOKUP_URI, Uri.encode(phoneOrEmail));
            kotlin.jvm.internal.p.h(uriWithAppendedPath, "withAppendedPath(...)");
            cursorQuerySafe = querySafe(uriWithAppendedPath, new String[]{CONTACT_ID, LOOKUP_KEY, DATA1}, null, null, null);
        } else {
            cursorQuerySafe = null;
        }
        if ((cursorQuerySafe == null || cursorQuerySafe.getCount() == 0) && (this.adapterInputType & 1) == 1) {
            if (cursorQuerySafe != null) {
                cursorQuerySafe.close();
            }
            Uri uriWithAppendedPath2 = Uri.withAppendedPath(ContactsContract.PhoneLookup.CONTENT_FILTER_URI, Uri.encode(phoneOrEmail));
            kotlin.jvm.internal.p.h(uriWithAppendedPath2, "withAppendedPath(...)");
            cursorQuerySafe = querySafe(uriWithAppendedPath2, new String[]{StepOSRecipientEmailHistory._ID, LOOKUP_KEY, Const.JSON_KEY_NUMBER}, null, null, null);
        }
        if ((cursorQuerySafe == null || cursorQuerySafe.getCount() == 0) && (this.adapterInputType & 2) == 2) {
            if (cursorQuerySafe != null) {
                cursorQuerySafe.close();
            }
            Uri uriWithAppendedPath3 = Uri.withAppendedPath(ContactsContract.CommonDataKinds.Email.CONTENT_LOOKUP_URI, Uri.encode(phoneOrEmail));
            kotlin.jvm.internal.p.h(uriWithAppendedPath3, "withAppendedPath(...)");
            i10 = 2;
            cursorQuerySafe = querySafe(uriWithAppendedPath3, new String[]{CONTACT_ID, LOOKUP_KEY, DATA1}, null, null, null);
        } else {
            i10 = 2;
        }
        if (cursorQuerySafe != null && cursorQuerySafe.moveToFirst()) {
            long j10 = cursorQuerySafe.getLong(0);
            String string = cursorQuerySafe.getString(1);
            if (cursorQuerySafe.getCount() > 1 && !kotlin.jvm.internal.p.d(phoneOrEmail, cursorQuerySafe.getString(i10))) {
                while (true) {
                    if (!cursorQuerySafe.moveToNext()) {
                        break;
                    }
                    if (kotlin.jvm.internal.p.d(phoneOrEmail, cursorQuerySafe.getString(i10))) {
                        j10 = cursorQuerySafe.getLong(0);
                        string = cursorQuerySafe.getString(1);
                        break;
                    }
                }
            }
            lookupUri = ContactsContract.Contacts.getLookupUri(j10, string);
        }
        if (cursorQuerySafe != null) {
            cursorQuerySafe.close();
        }
        if (lookupUri != null) {
            type = new Intent("android.intent.action.VIEW", lookupUri);
        } else {
            type = new Intent("android.intent.action.VIEW").setType("vnd.android.cursor.dir/data");
            kotlin.jvm.internal.p.f(type);
        }
        Bundle bundle = new Bundle();
        if ((this.adapterInputType & 1) == 1 && isPhoneNumber(phoneOrEmail)) {
            bundle.putString("phone", phoneOrEmail);
            bundle.putString("name", name);
            bundle.putString("action", "vnd.android.cursor.item/phone_v2");
        } else if ((this.adapterInputType & 4) == 4 && isSns(phoneOrEmail)) {
            bundle.putString(SOCIAL_PROFILE, phoneOrEmail);
            bundle.putString("action", CONTENT_ITEM_TYPE);
        } else {
            bundle.putString("email", phoneOrEmail);
            bundle.putString("name", phoneOrEmail);
            bundle.putString("action", "vnd.android.cursor.item/email_v2");
        }
        bundle.putString(SUB_TITLE_EXTRA_KEY, this.appContext.getString(com.stepos.widget.R.string.stepos_recipient_title));
        bundle.putString(TITLE_EXTRA_KEY, this.adapterInputType == i10 ? this.appContext.getString(com.stepos.widget.R.string.stepos_recipient_title_email) : this.appContext.getString(com.stepos.widget.R.string.stepos_recipient_title_message));
        type.putExtras(bundle);
        if (!(this.appContext instanceof Activity)) {
            type.addFlags(1342177280);
        }
        this.appContext.startActivity(type);
        Log.d(TAG, "goContactDetail:" + this.adapterInputType);
    }

    @Override // com.stepos.widget.recipient.StepOSRecipientBaseAdapter
    public boolean isEmailAddress(String address) {
        kotlin.jvm.internal.p.i(address, "address");
        if (TextUtils.isEmpty(address)) {
            return false;
        }
        return Patterns.EMAIL_ADDRESS.matcher(INSTANCE.extractAddrSpec(address)).matches();
    }

    @Override // com.stepos.widget.recipient.StepOSRecipientBaseAdapter
    public boolean isPhoneNumber(String number) {
        kotlin.jvm.internal.p.i(number, "number");
        if (TextUtils.isEmpty(number)) {
            return false;
        }
        return PHONE.matcher(number).matches();
    }

    @Override // com.stepos.widget.recipient.StepOSRecipientBaseAdapter
    public boolean isSns(String number) {
        kotlin.jvm.internal.p.i(number, "number");
        if (TextUtils.isEmpty(number) || number.length() == 1) {
            return false;
        }
        return D.X(number, "@", false, 2, null);
    }

    @Override // com.stepos.widget.recipient.StepOSCompositeCursorAdapter
    public View newHeaderView(Context context, int partition, Cursor cursor, ViewGroup parent) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(parent, "parent");
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        kotlin.jvm.internal.p.h(layoutInflaterFrom, "from(...)");
        View viewInflate = layoutInflaterFrom.inflate(com.stepos.widget.R.layout.stepos_recipient_dropdown_loading, parent, false);
        kotlin.jvm.internal.p.h(viewInflate, "inflate(...)");
        viewInflate.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.widget.recipient.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StepOSEmailRecipientAdapter.newHeaderView$lambda$1(this.f31311a, view);
            }
        });
        Log.d(TAG, "newHeaderView:" + this.adapterInputType);
        return viewInflate;
    }

    @Override // com.stepos.widget.recipient.StepOSCompositeCursorAdapter
    public View newView(Context context, int partition, Cursor cursor, int position, ViewGroup parent) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(cursor, "cursor");
        kotlin.jvm.internal.p.i(parent, "parent");
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        kotlin.jvm.internal.p.h(layoutInflaterFrom, "from(...)");
        Log.d(TAG, "newView:" + this.adapterInputType);
        View viewInflate = layoutInflaterFrom.inflate(com.stepos.widget.R.layout.stepos_recipient_dropdown_item, parent, false);
        kotlin.jvm.internal.p.h(viewInflate, "inflate(...)");
        return viewInflate;
    }

    @Override // com.stepos.widget.recipient.StepOSRecipientBaseAdapter
    public Object onDefaultFiltering(CharSequence constraint) throws IOException {
        Cursor cursor;
        Cursor cursorOnFiltering;
        String string;
        this.defaultData.clear();
        Cursor cursorOnSnsFiltering = null;
        String string2 = (constraint == null || (string = constraint.toString()) == null) ? null : H.D1(string).toString();
        if (string2 == null) {
            string2 = "";
        }
        if (TextUtils.isEmpty(string2)) {
            cursor = null;
            cursorOnFiltering = null;
        } else {
            Cursor groupData = getGroupData(string2);
            cursorOnFiltering = onFiltering(string2, false, -1L);
            if ((this.adapterInputType & 4) == 4 && D.X(string2, "@", false, 2, null)) {
                cursorOnSnsFiltering = onSnsFiltering(string2, false);
            }
            cursor = cursorOnSnsFiltering;
            cursorOnSnsFiltering = groupData;
        }
        Log.d(TAG, "onDefaultFiltering:" + this.adapterInputType);
        return new Cursor[]{cursorOnSnsFiltering, cursorOnFiltering, cursor};
    }

    @Override // com.stepos.widget.recipient.StepOSRecipientBaseAdapter
    public void onDefaultLoadFinished(CharSequence constraint, Cursor groupCursor, Cursor contactCursor, Cursor snsCursor) {
        boolean z10;
        String string;
        setNotificationsEnabled(false);
        String string2 = (constraint == null || (string = constraint.toString()) == null) ? null : H.D1(string).toString();
        if (string2 == null) {
            string2 = "";
        }
        if ((groupCursor == null || groupCursor.getCount() <= 0) && (contactCursor == null || contactCursor.getCount() <= 0)) {
            z10 = false;
        } else {
            this.onlyGlobal = false;
            close();
            addPartition(new StepOSRecipientBaseAdapter.GroupPartition());
            changeCursor(0, groupCursor);
            addPartition(false, false);
            changeCursor(1, contactCursor);
            z10 = true;
        }
        this.snsSearch = false;
        this.snsFirstSearch = false;
        if ((this.adapterInputType & 4) == 4 && D.X(string2, "@", false, 2, null)) {
            this.directories.clear();
            this.onlyGlobal = false;
            if (!z10) {
                close();
            }
            StepOSRecipientBaseAdapter.SnsPartition snsPartition = this.snsPartition;
            if (snsPartition == null) {
                snsPartition = new StepOSRecipientBaseAdapter.SnsPartition();
            }
            this.snsPartition = snsPartition;
            snsPartition.setConstraint(constraint);
            addPartition(snsPartition);
            int size = getSize() - 1;
            this.snsPartitionIndex = size;
            changeCursor(size, snsCursor);
            this.snsSearch = true;
            this.snsLoading = false;
            showLoading();
        } else if (this.openGlobalAddressBook && !TextUtils.isEmpty(string2) && canGlobalSearch(constraint)) {
            this.snsPartition = null;
            this.closeDelayed = false;
            if (!z10 && (!this.onlyGlobal || !this.autoGlobalSearch)) {
                this.onlyGlobal = true;
                close();
            } else if (this.onlyGlobal) {
                this.closeDelayed = true;
            }
            StepOSCompositeCursorAdapter.Partition partition = this.preferredDirectory;
            if (!this.closeDelayed && partition != null) {
                addPartition(partition);
                this.preferredDirectoryIndex = getSize() - 1;
            }
            this.globalSearchDelayed = false;
            if (!this.autoGlobalSearch) {
                this.snsPartition = null;
                this.directories.clear();
                if (!z10) {
                    close();
                }
            } else if (this.onlyGlobal) {
                startGlobalSearch();
            } else {
                this.globalSearchDelayed = true;
                showLoading();
            }
            setNotificationsEnabled(true);
        }
        Log.d(TAG, "onDefaultLoadFinished:" + this.adapterInputType);
    }

    @Override // com.stepos.widget.recipient.StepOSRecipientBaseAdapter
    public Object onDirectoryFiltering(CharSequence constraint, long directoryId) {
        String string;
        String string2 = (constraint == null || (string = constraint.toString()) == null) ? null : H.D1(string).toString();
        if (string2 == null) {
            string2 = "";
        }
        Cursor cursorOnFiltering = TextUtils.isEmpty(string2) ? null : onFiltering(string2, true, directoryId);
        Log.d(TAG, "onDirectoryFiltering:" + this.adapterInputType);
        return cursorOnFiltering;
    }

    @Override // com.stepos.widget.recipient.StepOSRecipientBaseAdapter
    public void onDirectoryLoadFinished(CharSequence constraint, long directoryId, Cursor cursor) {
        StepOSRecipientBaseAdapter.DirectoryPartition directoryPartition = this.directories.get(Long.valueOf(directoryId));
        if (directoryPartition != null && TextUtils.equals(constraint, directoryPartition.getConstraint())) {
            this.directories.remove(Long.valueOf(directoryId));
            MatrixCursor matrixCursor = new MatrixCursor(StepOSRecipientBaseAdapter.PROJECTION);
            if (cursor != null && cursor.getCount() > 0) {
                cursor.moveToPosition(-1);
                while (cursor.moveToNext()) {
                    if (cursor.getColumnCount() > 1) {
                        String string = cursor.getString(0);
                        if (string == null) {
                            string = "";
                        }
                        String string2 = cursor.getString(1);
                        if (string2 == null) {
                            string2 = "";
                        }
                        String string3 = cursor.getString(2);
                        String str = string3 != null ? string3 : "";
                        if (!this.defaultData.containsKey(string2) && !this.directoryData.contains(string2)) {
                            this.directoryData.add(string2);
                            MatrixCursor.RowBuilder rowBuilderNewRow = matrixCursor.newRow();
                            kotlin.jvm.internal.p.h(rowBuilderNewRow, "newRow(...)");
                            rowBuilderNewRow.add(string);
                            rowBuilderNewRow.add(string2);
                            rowBuilderNewRow.add(str);
                            rowBuilderNewRow.add(0L);
                        }
                    }
                }
            }
            if (matrixCursor.getCount() > 0) {
                setNotificationsEnabled(false);
                cancelLoading();
                if (this.closeDelayed) {
                    this.closeDelayed = false;
                    close();
                    StepOSCompositeCursorAdapter.Partition partition = this.preferredDirectory;
                    if (partition != null) {
                        addPartition(partition);
                        this.preferredDirectoryIndex = 0;
                    }
                }
                if (directoryPartition == this.preferredDirectory) {
                    changeCursor(this.preferredDirectoryIndex, matrixCursor);
                } else {
                    addPartition(directoryPartition);
                    changeCursor(getSize() - 1, matrixCursor);
                }
                if (!this.directories.isEmpty()) {
                    showLoading();
                }
                setNotificationsEnabled(true);
            } else if (this.directories.isEmpty()) {
                if (this.closeDelayed) {
                    this.closeDelayed = false;
                    close();
                } else {
                    cancelLoading();
                }
            }
        }
        Log.d(TAG, "onDirectoryLoadFinished:" + this.adapterInputType);
        if (cursor != null) {
            cursor.close();
        }
    }

    @Override // com.stepos.widget.recipient.StepOSRecipientBaseAdapter
    public Cursor onSnsFiltering(String constraint, boolean queryByNetwork) {
        kotlin.jvm.internal.p.i(constraint, "constraint");
        if (D.X(constraint, "@", false, 2, null)) {
            constraint = constraint.substring(1);
            kotlin.jvm.internal.p.h(constraint, "substring(...)");
        }
        Uri uriBuild = SNS_FILTER_URI;
        if (!TextUtils.isEmpty(constraint)) {
            uriBuild = uriBuild.buildUpon().appendQueryParameter("filter_words", constraint).build();
        }
        Cursor cursorQuerySafe = querySafe(uriBuild.buildUpon().appendQueryParameter("query_by_network", String.valueOf(queryByNetwork)).build(), new String[]{StepOSRecipientEmailHistory._ID, "screen_name"}, null, null, null);
        if (cursorQuerySafe == null) {
            return null;
        }
        MatrixCursor matrixCursor = new MatrixCursor(StepOSRecipientBaseAdapter.PROJECTION);
        try {
            cursorQuerySafe.moveToPosition(-1);
            while (cursorQuerySafe.moveToNext()) {
                MatrixCursor.RowBuilder rowBuilderNewRow = matrixCursor.newRow();
                kotlin.jvm.internal.p.h(rowBuilderNewRow, "newRow(...)");
                rowBuilderNewRow.add("");
                String string = cursorQuerySafe.getString(1);
                if (string == null) {
                    string = "";
                }
                rowBuilderNewRow.add("@" + string);
            }
            return matrixCursor;
        } finally {
            cursorQuerySafe.close();
        }
    }

    @Override // com.stepos.widget.recipient.StepOSRecipientBaseAdapter
    public void onSnsLoadFinished(CharSequence constraint, Cursor cursor) {
        StepOSRecipientBaseAdapter.SnsPartition snsPartition = this.snsPartition;
        if (!this.snsSearch || snsPartition == null) {
            if (cursor != null) {
                cursor.close();
            }
        } else if (!TextUtils.equals(constraint, snsPartition.getConstraint())) {
            if (cursor != null) {
                cursor.close();
            }
        } else {
            this.snsLoading = false;
            changeCursor(this.snsPartitionIndex, cursor);
            if (this.snsFirstSearch) {
                this.snsFirstSearch = false;
            } else {
                cancelLoading();
            }
        }
    }

    public final void openGlobalAddressBook(boolean open) {
        this.openGlobalAddressBook = open;
    }

    @Override // com.stepos.widget.recipient.StepOSRecipientBaseAdapter
    public String queryDisplayName(String phoneOrEmail) {
        StepOSEmailRecipientAdapter stepOSEmailRecipientAdapter;
        Cursor cursorQuerySafe;
        kotlin.jvm.internal.p.i(phoneOrEmail, "phoneOrEmail");
        if ((this.adapterInputType & 4) == 4) {
            Uri uriWithAppendedPath = Uri.withAppendedPath(SOCIAL_PROFILE_LOOKUP_URI, Uri.encode(phoneOrEmail));
            kotlin.jvm.internal.p.h(uriWithAppendedPath, "withAppendedPath(...)");
            stepOSEmailRecipientAdapter = this;
            cursorQuerySafe = stepOSEmailRecipientAdapter.querySafe(uriWithAppendedPath, new String[]{StepOSRecipientEmailHistory.DISPLAY_NAME, DATA1}, null, null, null);
        } else {
            stepOSEmailRecipientAdapter = this;
            cursorQuerySafe = null;
        }
        if ((cursorQuerySafe == null || cursorQuerySafe.getCount() == 0) && (stepOSEmailRecipientAdapter.adapterInputType & 1) == 1) {
            if (cursorQuerySafe != null) {
                cursorQuerySafe.close();
            }
            Uri uriWithAppendedPath2 = Uri.withAppendedPath(ContactsContract.PhoneLookup.CONTENT_FILTER_URI, Uri.encode(phoneOrEmail));
            kotlin.jvm.internal.p.h(uriWithAppendedPath2, "withAppendedPath(...)");
            cursorQuerySafe = stepOSEmailRecipientAdapter.querySafe(uriWithAppendedPath2, new String[]{StepOSRecipientEmailHistory.DISPLAY_NAME, Const.JSON_KEY_NUMBER}, null, null, null);
        }
        if ((cursorQuerySafe == null || cursorQuerySafe.getCount() == 0) && (stepOSEmailRecipientAdapter.adapterInputType & 2) == 2) {
            if (cursorQuerySafe != null) {
                cursorQuerySafe.close();
            }
            Uri uriWithAppendedPath3 = Uri.withAppendedPath(ContactsContract.CommonDataKinds.Email.CONTENT_LOOKUP_URI, Uri.encode(phoneOrEmail));
            kotlin.jvm.internal.p.h(uriWithAppendedPath3, "withAppendedPath(...)");
            cursorQuerySafe = stepOSEmailRecipientAdapter.querySafe(uriWithAppendedPath3, new String[]{StepOSRecipientEmailHistory.DISPLAY_NAME, DATA1}, null, null, null);
        }
        String str = "";
        if (cursorQuerySafe != null && cursorQuerySafe.moveToFirst()) {
            String string = cursorQuerySafe.getString(0);
            if (string == null) {
                string = "";
            }
            if (cursorQuerySafe.getCount() <= 1 || kotlin.jvm.internal.p.d(phoneOrEmail, cursorQuerySafe.getString(1))) {
                str = string;
            } else {
                while (cursorQuerySafe.moveToNext()) {
                    if (kotlin.jvm.internal.p.d(phoneOrEmail, cursorQuerySafe.getString(1))) {
                        String string2 = cursorQuerySafe.getString(0);
                        if (string2 != null) {
                            str = string2;
                        }
                    }
                }
                str = string;
            }
        }
        if (cursorQuerySafe != null) {
            cursorQuerySafe.close();
        }
        return str;
    }

    @Override // com.stepos.widget.recipient.StepOSRecipientBaseAdapter
    public void registerContentObserver() {
        RecipientWorker recipientWorker = contentWorker;
        if (recipientWorker == null) {
            recipientWorker = new RecipientWorker("stepos_recipient_content");
            contentWorker = recipientWorker;
        }
        if (this.contentHandler == null) {
            recipientWorker.setRefCount(recipientWorker.getRefCount() + 1);
            this.contentHandler = new Handler(recipientWorker.getLooper()) { // from class: com.stepos.widget.recipient.StepOSEmailRecipientAdapter.registerContentObserver.1
                @Override // android.os.Handler
                public void handleMessage(Message msg) {
                    kotlin.jvm.internal.p.i(msg, "msg");
                    if (msg.what == 4) {
                        StepOSEmailRecipientAdapter stepOSEmailRecipientAdapter = this;
                        synchronized (stepOSEmailRecipientAdapter.mDirectoryLock) {
                            stepOSEmailRecipientAdapter.loadDirectories();
                            Log.d(StepOSEmailRecipientAdapter.TAG, "directorylist " + stepOSEmailRecipientAdapter.directoryList.size());
                        }
                    }
                }
            };
        }
        Log.d(TAG, "registerContentObserver:" + this.adapterInputType);
        ContentObserver contentObserver = this.directoryObserver;
        if (contentObserver != null) {
            this.mContentResolver.unregisterContentObserver(contentObserver);
        }
        Handler handler = this.contentHandler;
        kotlin.jvm.internal.p.f(handler);
        DirectoryObserver directoryObserver = new DirectoryObserver(this, handler);
        this.directoryObserver = directoryObserver;
        try {
            this.mContentResolver.registerContentObserver(DIRECTORIES_NOTIFY_URI, false, directoryObserver);
        } catch (IllegalArgumentException e10) {
            Log.w(TAG, "registerContentObserver invalid", e10);
        } catch (SecurityException e11) {
            Log.w(TAG, "registerContentObserver denied", e11);
        } catch (Exception e12) {
            Log.w(TAG, "registerContentObserver failed", e12);
        }
    }

    public final void setAccount(Account account) {
        this.account = account;
    }

    public final void setRecipientAdapterEx(RecipientAdapterEx listener) {
        this.adapterExListener = listener;
    }

    public final void startSnsSearch(boolean queryByNetwork) {
        StepOSRecipientBaseAdapter.SnsPartition snsPartition = this.snsPartition;
        if (snsPartition == null) {
            return;
        }
        StepOSRecipientBaseAdapter.SnsPartitionFilter filter = snsPartition.getFilter();
        if (filter == null) {
            filter = new StepOSRecipientBaseAdapter.SnsPartitionFilter();
            snsPartition.setFilter(filter);
        }
        Log.d(TAG, "startSnsSearch:" + this.adapterInputType);
        filter.setMQueryByNetwork(queryByNetwork);
        filter.filter(snsPartition.getConstraint());
    }

    @Override // com.stepos.widget.recipient.StepOSRecipientBaseAdapter
    public void unregisterContentObserver() {
        Log.d(TAG, "unregisterContentObserver:" + this.adapterInputType);
        ContentObserver contentObserver = this.directoryObserver;
        if (contentObserver != null) {
            try {
                this.mContentResolver.unregisterContentObserver(contentObserver);
            } catch (Exception e10) {
                Log.w(TAG, "unregisterContentObserver failed", e10);
            }
            this.directoryObserver = null;
        }
    }
}
