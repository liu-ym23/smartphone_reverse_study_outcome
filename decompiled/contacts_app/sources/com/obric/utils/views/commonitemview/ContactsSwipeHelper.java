package com.obric.utils.views.commonitemview;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.telephony.PhoneNumberUtils;
import android.widget.Toast;
import com.android.contacts.ContactSaveService;
import com.android.contacts.R;
import com.android.contacts.bytedanceosquickcontact.Action;
import com.android.contacts.bytedanceosquickcontact.ActionMultiMap;
import com.android.contacts.bytedanceosquickcontact.DataAction;
import com.android.contacts.bytedanceosquickcontact.QuickContactHandle;
import com.android.contacts.bytedanceosquickcontact.ResolveCache;
import com.android.contacts.group.GroupSelectionActivity;
import com.android.contacts.list.ContactDetailCacheManager;
import com.android.contacts.util.BytedanceContactContract;
import com.android.contacts.util.NotifyingAsyncQueryHandler;
import com.bytedance.framwork.core.sdklib.DBHelper;
import com.obric.contactsdk.loader.CallFeatureEntityUtilKt;
import com.obric.oui.common.util.ToolsExtKt;
import com.obric.oui.material.MaterialConfigFormatNames;
import com.obric.utils.views.commonitemview.bean.SwipeItemButtonType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ContactsSwipeHelper.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0018\u0018\u0000 M2\u00020\u0001:\u0002MNB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u00101\u001a\u00020\u00122\b\u00102\u001a\u0004\u0018\u000103H\u0002J\u0018\u00104\u001a\u00020\"2\u0006\u00105\u001a\u00020\u001d2\u0006\u00106\u001a\u000207H\u0002J4\u00108\u001a\u0012\u0012\u0004\u0012\u00020\u001d0\u001cj\b\u0012\u0004\u0012\u00020\u001d`\u001e2\u001a\u00109\u001a\u0016\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001cj\n\u0012\u0004\u0012\u00020\u001d\u0018\u0001`\u001eH\u0002J\u0090\u0001\u0010:\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010!\u001a\u00020\"2\u0006\u0010;\u001a\u00020\u00042\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0/2\u0016\b\u0002\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00112H\u0010\n\u001aD\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\r0\f¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00120\u000bJ\u009a\u0001\u0010:\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010!\u001a\u00020\"2\b\u0010<\u001a\u0004\u0018\u00010\u00042\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0/2\u0016\b\u0002\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00112H\u0010\n\u001aD\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\r0\f¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00120\u000bJ\b\u0010=\u001a\u00020\u0012H\u0002J\"\u0010>\u001a\u00020\u00122\u001a\u0010?\u001a\u0016\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001cj\n\u0012\u0004\u0012\u00020\u001d\u0018\u0001`\u001eJ\u000e\u0010@\u001a\u00020\u00122\u0006\u0010A\u001a\u00020\rJ\u0018\u0010B\u001a\u00020\u00122\u0006\u00105\u001a\u00020\u001d2\u0006\u0010C\u001a\u00020\u0004H\u0002J\u000e\u0010D\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0015J\u0010\u0010E\u001a\u00020\u00122\u0006\u0010F\u001a\u00020\"H\u0002J\u0016\u0010G\u001a\u00020\u00122\u000e\u0010H\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010%J\b\u0010I\u001a\u00020\u0012H\u0002J\b\u0010J\u001a\u00020\u0012H\u0002J\b\u0010K\u001a\u00020\u0012H\u0002J\b\u0010L\u001a\u00020\u0012H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tRP\u0010\n\u001aD\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\r0\f¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00120\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u001b\u001a\u0016\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001cj\n\u0012\u0004\u0012\u00020\u001d\u0018\u0001`\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u0004¢\u0006\u0002\n\u0000RF\u0010)\u001a\u0016\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001cj\n\u0012\u0004\u0012\u00020\u001d\u0018\u0001`\u001e2\u001a\u0010(\u001a\u0016\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001cj\n\u0012\u0004\u0012\u00020\u001d\u0018\u0001`\u001e@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0/X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u00100\u001a\u0016\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001cj\n\u0012\u0004\u0012\u00020\u001d\u0018\u0001`\u001eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006O"}, d2 = {"Lcom/obric/utils/views/commonitemview/ContactsSwipeHelper;", "", "()V", ContactSaveService.EXTRA_ACCOUNT_NAME, "", ContactSaveService.EXTRA_ACCOUNT_TYPE, "actionMultiMap", "Lcom/android/contacts/bytedanceosquickcontact/ActionMultiMap;", "getActionMultiMap", "()Lcom/android/contacts/bytedanceosquickcontact/ActionMultiMap;", "callback", "Lkotlin/Function2;", "", "Lcom/obric/utils/views/commonitemview/bean/SwipeItemButtonType;", "Lkotlin/ParameterName;", "name", "swipeList", "Lkotlin/Function1;", "", "swipeClickListener", ContactSaveService.EXTRA_CONTACT_ID, "", "context", "Landroid/content/Context;", ContactSaveService.EXTRA_DATA_ID, "dataUri", "Landroid/net/Uri;", "favoriteActions", "Ljava/util/ArrayList;", "Lcom/android/contacts/bytedanceosquickcontact/Action;", "Lkotlin/collections/ArrayList;", "handler", "Lcom/android/contacts/util/NotifyingAsyncQueryHandler;", "isProfile", "", "lookupUri", "mPreferDataIds", "", "mQueryListener", "Lcom/android/contacts/util/NotifyingAsyncQueryHandler$AsyncQueryListener;", "<set-?>", "phoneActions", "getPhoneActions", "()Ljava/util/ArrayList;", "quickContactHandle", "Lcom/android/contacts/bytedanceosquickcontact/QuickContactHandle;", ContactSaveService.EXTRA_RAW_CONTACT_ID, "", "unFavoriteActions", "bindCursor", "cursor", "Landroid/database/Cursor;", "considerAdd", CallFeatureEntityUtilKt.PARAM_KEY_ACTION, "resolveCache", "Lcom/android/contacts/bytedanceosquickcontact/ResolveCache;", "getPhoneList", "actionList", "init", "lookUri", "lookKey", "initPhotoData", "initQuickBtnStar", "actions", "onSwipeItemButtonClick", "buttonType", "removeUnstarredAction", "number", "setDataId", "setFavoriteChecked", MaterialConfigFormatNames.CHECKED, "setPreferDataIds", "dataIds", "show", "showCache", "starClicked", "updateSwipeStatus", "Companion", "DataQuery", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ContactsSwipeHelper {
    public static final Companion Companion = null;
    private static final int HANDLER_ID_DATA = 1;
    private String accountName;
    private String accountType;
    private final ActionMultiMap actionMultiMap;
    private Function2<? super List<? extends SwipeItemButtonType>, ? super Function1<? super SwipeItemButtonType, Unit>, Unit> callback;
    private long contactId;
    private Context context;
    private long dataId;
    private Uri dataUri;
    private ArrayList<Action> favoriteActions;
    private NotifyingAsyncQueryHandler handler;
    private boolean isProfile;
    private Uri lookupUri;
    private Set<Long> mPreferDataIds;
    private final NotifyingAsyncQueryHandler.AsyncQueryListener mQueryListener;
    private ArrayList<Action> phoneActions;
    private QuickContactHandle quickContactHandle;
    private long rawContactId;
    private Function1<? super SwipeItemButtonType, Unit> swipeClickListener;
    private final List<SwipeItemButtonType> swipeList;
    private ArrayList<Action> unFavoriteActions;

    /* JADX INFO: compiled from: ContactsSwipeHelper.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/utils/views/commonitemview/ContactsSwipeHelper$Companion;", "", "()V", "HANDLER_ID_DATA", "", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: ContactsSwipeHelper.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/obric/utils/views/commonitemview/ContactsSwipeHelper$DataQuery;", "", "Companion", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface DataQuery {
        public static final int ACCOUNT_NAME = 17;
        public static final int ACCOUNT_TYPE = 1;
        public static final int CHAT_CAPABILITY = 11;
        public static final int CONTACT_ID = 18;
        public static final Companion Companion = null;
        public static final int DATA_SET = 2;
        public static final int DISPLAY_NAME = 4;
        public static final int IS_PRIMARY = 14;
        public static final int IS_SUPER_PRIMARY = 15;
        public static final int MIMETYPE = 13;
        public static final int PRESENCE = 10;
        public static final int RAW_CONTACT_ID = 16;
        public static final int RES_PACKAGE = 12;
        public static final int STARRED = 3;
        public static final int STATUS = 5;
        public static final int STATUS_ICON = 7;
        public static final int STATUS_LABEL = 8;
        public static final int STATUS_RES_PACKAGE = 6;
        public static final int STATUS_TIMESTAMP = 9;
        public static final int _ID = 0;

        /* JADX INFO: compiled from: ContactsSwipeHelper.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0019\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/obric/utils/views/commonitemview/ContactsSwipeHelper$DataQuery$Companion;", "", "()V", "ACCOUNT_NAME", "", "ACCOUNT_TYPE", "CHAT_CAPABILITY", "CONTACT_ID", "DATA_SET", "DISPLAY_NAME", "IS_PRIMARY", "IS_SUPER_PRIMARY", "MIMETYPE", "PRESENCE", "PROJECTION", "", "", "getPROJECTION", "()[Ljava/lang/String;", "[Ljava/lang/String;", "RAW_CONTACT_ID", "RES_PACKAGE", "STARRED", "STATUS", "STATUS_ICON", "STATUS_LABEL", "STATUS_RES_PACKAGE", "STATUS_TIMESTAMP", "_ID", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = null;
            public static final int ACCOUNT_NAME = 17;
            public static final int ACCOUNT_TYPE = 1;
            public static final int CHAT_CAPABILITY = 11;
            public static final int CONTACT_ID = 18;
            public static final int DATA_SET = 2;
            public static final int DISPLAY_NAME = 4;
            public static final int IS_PRIMARY = 14;
            public static final int IS_SUPER_PRIMARY = 15;
            public static final int MIMETYPE = 13;
            public static final int PRESENCE = 10;
            private static final String[] PROJECTION = null;
            public static final int RAW_CONTACT_ID = 16;
            public static final int RES_PACKAGE = 12;
            public static final int STARRED = 3;
            public static final int STATUS = 5;
            public static final int STATUS_ICON = 7;
            public static final int STATUS_LABEL = 8;
            public static final int STATUS_RES_PACKAGE = 6;
            public static final int STATUS_TIMESTAMP = 9;
            public static final int _ID = 0;

            private Companion() {
            }

            public final String[] getPROJECTION() {
                return PROJECTION;
            }

            static {
                $$INSTANCE = new Companion();
                PROJECTION = new String[]{"_id", "account_type", "data_set", ContactSaveService.EXTRA_STARRED_FLAG, "display_name", "status", "status_res_package", "status_icon", "status_label", "status_ts", "mode", "chat_capability", "res_package", "mimetype", "is_primary", "is_super_primary", GroupSelectionActivity.EXTRA_RAW_CONTACT_ID, "account_name", "contact_id", "data1", DBHelper.COL_DATA2, DBHelper.COL_DATA3, "data4", "data5", "data6", "data7", "data8", "data9", "data10", "data11", BytedanceContactContract.BytedancePhoneColumn.NUMBER_LOCATION_NAME, BytedanceContactContract.BytedancePhoneColumn.NUMBER_LOCATION_NAME_PINYIN, "data14", BytedanceContactContract.BytedancePhoneColumn.NUMBER_FAVORITE_TAG};
            }
        }

        static {
            Companion = Companion.$$INSTANCE;
        }
    }

    /* JADX INFO: compiled from: ContactsSwipeHelper.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[SwipeItemButtonType.values().length];
            r0[SwipeItemButtonType.SWIPE_STAR.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L19:
            r0[SwipeItemButtonType.SWIPE_UNSTAR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L27:
            r0[SwipeItemButtonType.SWIPE_PHONE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L21:
            r0[SwipeItemButtonType.SWIPE_PHONE1.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[SwipeItemButtonType.SWIPE_PHONE2.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L17:
            r0[SwipeItemButtonType.SWIPE_MESSAGE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L9:
            $EnumSwitchMapping$0 = r0;
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$lNfSlLPgn8ohwhM_KRIx6-NVMw8, reason: not valid java name */
    public static /* synthetic */ void m785$r8$lambda$lNfSlLPgn8ohwhM_KRIx6NVMw8() {
        starClicked$lambda$0();
    }

    static {
        Companion = new Companion(null);
    }

    private static final void starClicked$lambda$0() {
    }

    public ContactsSwipeHelper() {
        this.dataId = -1;
        this.actionMultiMap = new ActionMultiMap();
        this.swipeList = new ArrayList();
        this.callback = ContactsSwipeHelper$callback$1.INSTANCE;
        this.mQueryListener = new ContactsSwipeHelper$mQueryListener$1(this);
    }

    public static final /* synthetic */ void access$bindCursor(ContactsSwipeHelper r0, Cursor r1) {
        r0.bindCursor(r1);
    }

    public static final /* synthetic */ Function2 access$getCallback$p(ContactsSwipeHelper r0) {
        return r0.callback;
    }

    public static final /* synthetic */ ArrayList access$getPhoneList(ContactsSwipeHelper r0, ArrayList r1) {
        return r0.getPhoneList(r1);
    }

    public static final /* synthetic */ List access$getSwipeList$p(ContactsSwipeHelper r0) {
        return r0.swipeList;
    }

    public static final /* synthetic */ void access$initPhotoData(ContactsSwipeHelper r0) {
        r0.initPhotoData();
    }

    public static final /* synthetic */ void access$setFavoriteChecked(ContactsSwipeHelper r0, boolean r1) {
        r0.setFavoriteChecked(r1);
    }

    public static final /* synthetic */ void access$setPhoneActions$p(ContactsSwipeHelper r0, ArrayList r1) {
        r0.phoneActions = r1;
    }

    public static final /* synthetic */ void access$updateSwipeStatus(ContactsSwipeHelper r0) {
        r0.updateSwipeStatus();
    }

    public final ArrayList<Action> getPhoneActions() {
        return this.phoneActions;
    }

    public final ActionMultiMap getActionMultiMap() {
        return this.actionMultiMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void init$default(ContactsSwipeHelper r7, Context r8, boolean r9, String r10, List r11, Function1 r12, Function2 r13, int r14, Object r15) {
        if ((r14 & 16) == 0) goto L5;
        r12 = null;
    L5:
        r7.init(r8, r9, r10, r11, r12, r13);
    }

    public final void init(Context r2, boolean r3, String r4, List<SwipeItemButtonType> r5, Function1<? super SwipeItemButtonType, Unit> r6, Function2<? super List<? extends SwipeItemButtonType>, ? super Function1<? super SwipeItemButtonType, Unit>, Unit> r7) {
        Intrinsics.checkNotNullParameter(r4, "lookUri");
        Intrinsics.checkNotNullParameter(r5, "swipeList");
        Intrinsics.checkNotNullParameter(r7, "callback");
        this.swipeList.clear();
        this.swipeList.addAll(r5);
        this.isProfile = r3;
        this.context = r2;
        this.handler = new NotifyingAsyncQueryHandler(r2, this.mQueryListener);
        this.lookupUri = Uri.parse(r4);
        this.swipeClickListener = r6;
        this.quickContactHandle = new QuickContactHandle(r2);
        this.callback = r7;
        showCache();
        show();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void init$default(ContactsSwipeHelper r10, Context r11, long r12, boolean r14, String r15, List r16, Function1 r17, Function2 r18, int r19, Object r20) {
        if ((r19 & 32) == 0) goto L5;
        Function1 r8 = null;
    L6:
        r10.init(r11, r12, r14, r15, r16, r8, r18);
        return;
    L5:
        r8 = r17;
        goto L6
    }

    public final void init(Context r2, long r3, boolean r5, String r6, List<SwipeItemButtonType> r7, Function1<? super SwipeItemButtonType, Unit> r8, Function2<? super List<? extends SwipeItemButtonType>, ? super Function1<? super SwipeItemButtonType, Unit>, Unit> r9) {
        Intrinsics.checkNotNullParameter(r7, "swipeList");
        Intrinsics.checkNotNullParameter(r9, "callback");
        this.swipeList.clear();
        this.swipeList.addAll(r7);
        this.isProfile = r5;
        this.context = r2;
        this.handler = new NotifyingAsyncQueryHandler(r2, this.mQueryListener);
        if (r5 == true) goto L5;
        Uri r4 = ContactsContract.Contacts.getLookupUri(r3, r6);
    L6:
        this.lookupUri = r4;
        this.swipeClickListener = r8;
        this.quickContactHandle = new QuickContactHandle(r2);
        this.callback = r9;
        showCache();
        show();
        return;
    L5:
        r4 = ContentUris.withAppendedId(Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_LOOKUP_URI, "profile"), r3);
        goto L6
    }

    private final void updateSwipeStatus() {
        ToolsExtKt.runInUIThread(new AnonymousClass1(this));
    }

    private final ArrayList<Action> getPhoneList(ArrayList<Action> r11) {
        ArrayList<Action> r10 = new ArrayList();
        if (r11 == null) goto L32;
        int r0 = r11.size();
        int r2 = 0;
    L5:
        if (r2 >= r0) goto L32;
        String r3 = r11.get(r2).getData();
        String r4 = r3;
        if (r4 != null) goto L9;
    L12:
        boolean r5 = true;
    L13:
        if (r5 == true) goto L31;
        int r6 = r2 + 1;
        int r7 = r11.size();
        boolean r8 = false;
    L16:
        if (r6 >= r7) goto L29;
        String r9 = r11.get(r6).getData();
        String r12 = r9;
        if (r12 != null) goto L20;
    L23:
        boolean r13 = true;
    L24:
        if (r13 == true) goto L28;
        if (PhoneNumberUtils.compare(r3, r9) == false) goto L28;
        r8 = true;
    L28:
        r6 = r6 + 1;
        goto L16
    L20:
        if (StringsKt.isBlank(r12) == true) goto L23;
        r13 = false;
        goto L24
    L29:
        if (r8 == true) goto L31;
        r10.add(r11.get(r2));
    L31:
        r2 = r2 + 1;
        goto L5
    L9:
        if (StringsKt.isBlank(r4) == true) goto L12;
        r5 = false;
    L32:
        return r10;
    }

    public final void initQuickBtnStar(ArrayList<Action> r7) {
        this.unFavoriteActions = new ArrayList();
        this.favoriteActions = new ArrayList();
        Intrinsics.checkNotNull(r7);
        int r0 = r7.size();
        boolean r1 = false;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L10;
        Action r3 = r7.get(r2);
        Intrinsics.checkNotNullExpressionValue(r3, "actions[i]");
        Action r4 = r3;
        Boolean r5 = r4.isStarred();
        Intrinsics.checkNotNullExpressionValue(r5, "action.isStarred");
        if (r5.booleanValue() == false) goto L7;
        ArrayList<Action> r6 = this.favoriteActions;
        Intrinsics.checkNotNull(r6);
        r6.add(r4);
    L8:
        r2 = r2 + 1;
        goto L3
    L7:
        ArrayList<Action> r8 = this.unFavoriteActions;
        Intrinsics.checkNotNull(r8);
        r8.add(r4);
        goto L8
    L10:
        if ((!r7.isEmpty()) == false) goto L14;
        ArrayList<Action> r9 = this.favoriteActions;
        Intrinsics.checkNotNull(r9);
        if (r9.size() != r7.size()) goto L14;
        r1 = true;
    L14:
        setFavoriteChecked(r1);
    }

    private final void setFavoriteChecked(boolean r3) {
        if (this.swipeList.contains(SwipeItemButtonType.SWIPE_STAR) == false) goto L5;
    L6:
        this.swipeList.remove(SwipeItemButtonType.SWIPE_STAR);
        this.swipeList.remove(SwipeItemButtonType.SWIPE_UNSTAR);
        if (r3 == false) goto L9;
        this.swipeList.add(SwipeItemButtonType.SWIPE_UNSTAR);
        return;
    L9:
        this.swipeList.add(SwipeItemButtonType.SWIPE_STAR);
        return;
    L5:
        if (this.swipeList.contains(SwipeItemButtonType.SWIPE_UNSTAR) == true) goto L6;
    }

    public final void setDataId(long r1) {
        this.dataId = r1;
    }

    public final void setPreferDataIds(Set<Long> r1) {
        this.mPreferDataIds = r1;
    }

    public final void onSwipeItemButtonClick(SwipeItemButtonType r4) {
        Intrinsics.checkNotNullParameter(r4, "buttonType");
        switch(WhenMappings.$EnumSwitchMapping$0[r4.ordinal()]) {
            case 1: goto L12;
            case 2: goto L12;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            default: goto L4;
        };
    L4:
        Function1<? super SwipeItemButtonType, Unit> r3 = this.swipeClickListener;
        if (r3 == null) goto L16;
        r3.invoke(r4);
        return;
    L16:
        return;
    L7:
        QuickContactHandle r5 = this.quickContactHandle;
        Intrinsics.checkNotNull(r5);
        r5.placeMmsActions(this.phoneActions);
        return;
    L8:
        QuickContactHandle r6 = this.quickContactHandle;
        Intrinsics.checkNotNull(r6);
        r6.placeCallActions(this.phoneActions, 1, "mTrackerTag");
        return;
    L9:
        QuickContactHandle r7 = this.quickContactHandle;
        Intrinsics.checkNotNull(r7);
        r7.placeCallActions(this.phoneActions, 0, "mTrackerTag");
        return;
    L10:
        QuickContactHandle r8 = this.quickContactHandle;
        Intrinsics.checkNotNull(r8);
        r8.placeCallActions(this.phoneActions, -1, "mTrackerTag");
        return;
    L12:
        if (this.isProfile == false) goto L14;
        Context r9 = this.context;
        Intrinsics.checkNotNull(r9);
        Toast.makeText(r9.getApplicationContext(), R.string.unabletostarred, 0).show();
        return;
    L14:
        starClicked();
    }

    private final void starClicked() {
        QuickContactHandle.Callback r0 = new ContactsSwipeHelper$$ExternalSyntheticLambda0();
        QuickContactHandle r1 = this.quickContactHandle;
        Intrinsics.checkNotNull(r1);
        r1.placeStarActions(this.phoneActions, r0);
    }

    private final void showCache() {
        ArrayList<Action> r0 = this.phoneActions;
        if (r0 == null) goto L6;
        initQuickBtnStar(r0);
        return;
    }

    private final void show() {
        if (this.isProfile == false) goto L5;
        Uri r0 = Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_LOOKUP_URI, "profile");
        Intrinsics.checkNotNull(r0);
        this.dataUri = Uri.withAppendedPath(ContentUris.withAppendedId(r0, this.contactId), "data");
    L6:
        NotifyingAsyncQueryHandler r1 = this.handler;
        Intrinsics.checkNotNull(r1);
        r1.cancelOperation(1);
        long r2 = this.dataId;
        if (r2 == (-1)) goto L9;
        String[] r8 = {String.valueOf(r2), "vnd.android.cursor.item/group_membership", "vnd.android.cursor.item/name", "vnd.android.cursor.item/vnd.com.tencent.mm.chatting.profile"};
        String r7 = "_id =? OR mimetype =? OR mimetype =? OR mimetype =? ";
    L10:
        Cursor r3 = ContactDetailCacheManager.getInstance().getSubCursorForQuickContact(this.lookupUri);
        if (r3 != null) goto L13;
    L15:
        NotifyingAsyncQueryHandler r4 = this.handler;
        Intrinsics.checkNotNull(r4);
        r4.startQuery(1, this.lookupUri, this.dataUri, DataQuery.Companion.getPROJECTION(), r7, r8, null);
        return;
    L13:
        if (r3.getCount() <= 0) goto L15;
        this.mQueryListener.onQueryComplete(1, this.lookupUri, r3);
        goto L15
    L9:
        r7 = null;
        r8 = null;
        goto L10
    L5:
        this.dataUri = Uri.withAppendedPath(this.lookupUri, "data");
        goto L6
    }

    private final void bindCursor(Cursor r14) {
        this.actionMultiMap.clear();
        HashMap r0 = new HashMap();
        if (r14 != null) goto L5;
        return;
    L5:
        if (r14.moveToFirst() == false) goto L58;
        ResolveCache r1 = ResolveCache.getInstance(this.context);
        this.rawContactId = r14.getLong(16);
        this.contactId = r14.getLong(18);
        this.accountName = r14.getString(17);
        this.accountType = r14.getString(1);
    L7:
        String r3 = r14.getString(13);
        boolean r10 = false;
        if (this.dataId == (-1)) goto L22;
        if (Intrinsics.areEqual("vnd.android.cursor.item/phone_v2", r3) == false) goto L15;
        if (this.dataId == r14.getLong(0)) goto L15;
    L51:
        if (r14.moveToNext() == true) goto L7;
        return;
    L15:
        if (Intrinsics.areEqual("vnd.android.cursor.item/phone_v2", r3) == false) goto L17;
    L26:
        long r7 = r14.getLong(0);
        DataAction r12 = new DataAction();
        r12.setDataAction(this.context, r3, r7, r14);
        if (Intrinsics.areEqual("vnd.android.cursor.item/phone_v2", r3) == false) goto L49;
        String r4 = r12.getData();
        String r5 = r4;
        if (r5 != null) goto L31;
    L34:
        boolean r6 = true;
    L35:
        if (r6 == true) goto L51;
        Iterator r8 = r0.keySet().iterator();
    L39:
        if (r8.hasNext() == false) goto L44;
        String r9 = (String) r8.next();
        if (PhoneNumberUtils.compare(r9, r4) == false) goto L39;
        r10 = true;
        r4 = r9;
    L44:
        if (r10 == false) goto L48;
        Object r11 = r0.get(r4);
        Intrinsics.checkNotNull(r11);
        if (((Boolean) r11).booleanValue() == true) goto L51;
        Intrinsics.checkNotNullExpressionValue(r4, "number");
        removeUnstarredAction(r12, r4);
        goto L49
    L48:
        Intrinsics.checkNotNullExpressionValue(r4, "number");
        Boolean r13 = r12.isStarred();
        Intrinsics.checkNotNullExpressionValue(r13, "action.isStarred");
        r0.put(r4, r13);
        goto L49
    L31:
        if (StringsKt.isBlank(r5) == true) goto L34;
        r6 = false;
    L49:
        Intrinsics.checkNotNullExpressionValue(r1, "cache");
        considerAdd(r12, r1);
        goto L51
    L17:
        if (Intrinsics.areEqual("vnd.android.cursor.item/group_membership", r3) == true) goto L26;
        if (Intrinsics.areEqual("vnd.android.cursor.item/vnd.com.tencent.mm.chatting.profile", r3) == true) goto L26;
    L22:
        if (Intrinsics.areEqual("vnd.android.cursor.item/phone_v2", r3) == true) goto L26;
        if (Intrinsics.areEqual("vnd.android.cursor.item/vnd.com.tencent.mm.chatting.profile", r3) == true) goto L26;
    }

    private final void removeUnstarredAction(Action r4, String r5) {
        ArrayList<Action> r3 = this.actionMultiMap.get("vnd.android.cursor.item/phone_v2");
        if (r3 != null) goto L5;
        return;
    L5:
        if (r3.size() <= 0) goto L21;
        int r6 = r3.size() - 1;
        if (r6 < 0) goto L22;
    L8:
        int r0 = r6 - 1;
        Action r1 = r3.get(r6);
        if (r1 != null) goto L11;
    L15:
        if (r0 < 0) goto L24;
        r6 = r0;
        goto L8
    L24:
        return;
    L11:
        if (r1.getData() == null) goto L15;
        if (Intrinsics.areEqual(r1.getData(), r5) == false) goto L15;
        r3.remove(r6);
        return;
    L22:
        return;
    }

    private final void initPhotoData() {
        ResolveCache r0 = ResolveCache.getInstance(this.context);
        DataAction r1 = new DataAction();
        r1.setDataAction(this.context, "vnd.android.cursor.item/photo", 0, null);
        Intrinsics.checkNotNullExpressionValue(r0, "cache");
        considerAdd(r1, r0);
        DataAction r2 = new DataAction();
        r2.setDataAction(this.context, "vnd.android.cursor.item/photo", 1, null);
        considerAdd(r2, r0);
    }

    private final boolean considerAdd(Action r8, ResolveCache r9) {
        boolean r1 = false;
        if (Intrinsics.areEqual(r8.getMimeType(), "vnd.android.cursor.item/group_membership") == true) goto L13;
        if (Intrinsics.areEqual(r8.getMimeType(), "vnd.android.cursor.item/photo") == true) goto L13;
        if (Intrinsics.areEqual("vnd.android.cursor.item/vnd.com.tencent.mm.chatting.profile", r8.getMimeType()) == true) goto L13;
        if (r9.hasResolve(r8) == true) goto L13;
        return false;
    L13:
        if (Intrinsics.areEqual("vnd.android.cursor.item/phone_v2", r8.getMimeType()) == false) goto L40;
        String r10 = r8.getData();
        if (r10 != null) goto L17;
    L20:
        boolean r11 = true;
    L21:
        if (r11 == false) goto L23;
        return false;
    L23:
        ArrayList<Action> r12 = this.actionMultiMap.get(r8.getMimeType());
        if (r12 == null) goto L40;
        int r2 = r12.size();
        int r3 = 0;
        boolean r4 = false;
    L26:
        if (r3 >= r2) goto L39;
        String r5 = r12.get(r3).getData();
        String r6 = r5;
        if (r6 != null) goto L30;
    L33:
        boolean r7 = true;
    L34:
        if (r7 == true) goto L38;
        if (PhoneNumberUtils.compare(r5, r8.getData()) == false) goto L38;
        r4 = true;
    L38:
        r3 = r3 + 1;
        goto L26
    L30:
        if (StringsKt.isBlank(r6) == true) goto L33;
        r7 = false;
        goto L34
    L39:
        r1 = r4;
        goto L40
    L17:
        if (StringsKt.isBlank(r10) == true) goto L20;
        r11 = false;
    L40:
        if (r1 == true) goto L42;
        this.actionMultiMap.put(r8.getMimeType(), r8);
    L42:
        return true;
    }
}
