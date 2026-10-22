package com.stepos.ailauncher.common.permission;

import Z8.C1173v;
import android.R;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.os.UserHandle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatui.panelui.PanelHomePolicy;
import com.stepos.ailauncher.common.permission.AbstractC3187d;
import com.stepos.ailauncher.contract.api.homegesture.HomeGestureEligibilityContract;
import com.stepos.ailauncher.foundation.credential.api.AuthSessionDto;
import com.stepos.policy.sdk.util.PolicySdkPermissionManifestUtils;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.jvm.internal.Ref$BooleanRef;
import net.sqlcipher.database.SQLiteDatabase;
import o6.C5009a;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000ô\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0007*\u0002¨\u0001\bÆ\u0002\u0018\u00002\u00020\u0001:\u0006«\u0001¬\u0001\u00ad\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u0003J\u000f\u0010\u000b\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\u0003J\u000f\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0016\u0010\u0017J#\u0010\u001a\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJU\u0010#\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001c2\b\b\u0002\u0010\u001f\u001a\u00020\u001e2$\u0010\"\u001a \u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\f0!\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t0 H\u0002¢\u0006\u0004\b#\u0010$J-\u0010(\u001a\u00020'2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010&\u001a\u00020%2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001cH\u0002¢\u0006\u0004\b(\u0010)J-\u0010,\u001a\u00020\t2\u0006\u0010+\u001a\u00020*2\u0006\u0010&\u001a\u00020%2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001cH\u0002¢\u0006\u0004\b,\u0010-J5\u00100\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010/\u001a\u00020.2\u0006\u0010&\u001a\u00020%2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001cH\u0002¢\u0006\u0004\b0\u00101J\r\u00102\u001a\u00020\f¢\u0006\u0004\b2\u0010\u000eJ\u001b\u00105\u001a\u00020\t2\f\u00104\u001a\b\u0012\u0004\u0012\u00020\t03¢\u0006\u0004\b5\u00106J\u0017\u00108\u001a\u00020\t2\u0006\u0010+\u001a\u000207H\u0000¢\u0006\u0004\b8\u00109J\u0017\u0010:\u001a\u00020\t2\u0006\u0010+\u001a\u000207H\u0000¢\u0006\u0004\b:\u00109J!\u0010<\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010;\u001a\u00020\fH\u0007¢\u0006\u0004\b<\u0010=J\r\u0010>\u001a\u00020\t¢\u0006\u0004\b>\u0010\u0003J\r\u0010?\u001a\u00020\t¢\u0006\u0004\b?\u0010\u0003J\r\u0010@\u001a\u00020\f¢\u0006\u0004\b@\u0010\u000eJ\u0017\u0010B\u001a\u00020\f2\u0006\u0010A\u001a\u00020%H\u0000¢\u0006\u0004\bB\u0010CJ\r\u0010D\u001a\u00020\f¢\u0006\u0004\bD\u0010\u000eJ\u001d\u0010F\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010E\u001a\u00020\u000f¢\u0006\u0004\bF\u0010GJ\u001d\u0010J\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010I\u001a\u00020H¢\u0006\u0004\bJ\u0010KJ\u001d\u0010L\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010I\u001a\u00020H¢\u0006\u0004\bL\u0010KJ\u0015\u0010M\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\bM\u0010NJ\u001f\u0010O\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010E\u001a\u00020\u000f¢\u0006\u0004\bO\u0010PJ\u0017\u0010Q\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\bQ\u0010RJ\u001f\u0010S\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0015\u001a\u00020\f¢\u0006\u0004\bS\u0010\u0017J\u0015\u0010U\u001a\u00020\t2\u0006\u0010T\u001a\u00020\f¢\u0006\u0004\bU\u0010VJK\u0010Z\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010I\u001a\u00020H2\b\b\u0002\u0010\u001f\u001a\u00020\u001e2\f\u0010W\u001a\b\u0012\u0004\u0012\u00020\t032\u0014\b\u0002\u0010Y\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t0X¢\u0006\u0004\bZ\u0010[J=\u0010\\\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010I\u001a\u00020H2\b\b\u0002\u0010\u001f\u001a\u00020\u001e2\u0014\b\u0002\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t0X¢\u0006\u0004\b\\\u0010]J)\u0010^\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010I\u001a\u00020H2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b^\u0010_Jm\u0010f\u001a\u0004\u0018\u00010e2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010`\u001a\u00020%2\b\b\u0001\u0010a\u001a\u00020%2\u0010\b\u0002\u0010b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u0001032\u0010\b\u0002\u0010c\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u0001032\u0010\b\u0002\u0010d\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u0001032\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\bf\u0010gJ3\u0010j\u001a\u00020\t2\u0006\u0010A\u001a\u00020%2\u0012\u0010h\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\f0!2\u0006\u0010i\u001a\u00020\fH\u0000¢\u0006\u0004\bj\u0010kJ\u0017\u0010l\u001a\u00020\t2\u0006\u0010A\u001a\u00020%H\u0000¢\u0006\u0004\bl\u0010mR\u0014\u0010n\u001a\u00020\u000f8\u0002X\u0082T¢\u0006\u0006\n\u0004\bn\u0010oR\u0014\u0010p\u001a\u00020\u000f8\u0002X\u0082T¢\u0006\u0006\n\u0004\bp\u0010oR\u0014\u0010q\u001a\u00020\u000f8\u0002X\u0082T¢\u0006\u0006\n\u0004\bq\u0010oR\u0014\u0010r\u001a\u00020\u000f8\u0002X\u0082T¢\u0006\u0006\n\u0004\br\u0010oR\u0014\u0010t\u001a\u00020s8\u0002X\u0082T¢\u0006\u0006\n\u0004\bt\u0010uR\u0014\u0010v\u001a\u00020s8\u0002X\u0082T¢\u0006\u0006\n\u0004\bv\u0010uR\u0014\u0010w\u001a\u00020%8\u0002X\u0082T¢\u0006\u0006\n\u0004\bw\u0010xR\u0018\u0010z\u001a\u0004\u0018\u00010y8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bz\u0010{R\u0018\u0010|\u001a\u0004\u0018\u00010e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b|\u0010}R\u0016\u0010~\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b~\u0010\u007fR\u001c\u0010\u0081\u0001\u001a\u0005\u0018\u00010\u0080\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0081\u0001\u0010\u0082\u0001R\u0016\u0010\u0083\u0001\u001a\u00020\u000f8\u0000X\u0080T¢\u0006\u0007\n\u0005\b\u0083\u0001\u0010oR\u0016\u0010\u0084\u0001\u001a\u00020\u000f8\u0000X\u0080T¢\u0006\u0007\n\u0005\b\u0084\u0001\u0010oR\u0016\u0010\u0085\u0001\u001a\u00020s8\u0002X\u0082T¢\u0006\u0007\n\u0005\b\u0085\u0001\u0010uR\u0018\u0010\u0087\u0001\u001a\u00030\u0086\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0087\u0001\u0010\u0088\u0001R\u0018\u0010\u008a\u0001\u001a\u00030\u0089\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008a\u0001\u0010\u008b\u0001R%\u0010\u008e\u0001\u001a\u0010\u0012\u0004\u0012\u00020%\u0012\u0005\u0012\u00030\u008d\u00010\u008c\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008e\u0001\u0010\u008f\u0001R+\u0010\u0091\u0001\u001a\u0005\u0018\u00010\u0090\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0006\b\u0091\u0001\u0010\u0092\u0001\u001a\u0005\bx\u0010\u0093\u0001\"\u0006\b\u0094\u0001\u0010\u0095\u0001R&\u0010\u0096\u0001\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0096\u0001\u0010\u007f\u001a\u0005\b\u0097\u0001\u0010\u000e\"\u0005\b\u0098\u0001\u0010VR\u001b\u0010\u0099\u0001\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0099\u0001\u0010\u009a\u0001R\u001e\u0010\u009c\u0001\u001a\t\u0012\u0004\u0012\u0002070\u009b\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u009c\u0001\u0010\u009d\u0001R\u0018\u0010\u009f\u0001\u001a\u00030\u009e\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u009f\u0001\u0010 \u0001R(\u0010¢\u0001\u001a\u00020s2\u0007\u0010¡\u0001\u001a\u00020s8\u0006@BX\u0086\u000e¢\u0006\u000e\n\u0005\b¢\u0001\u0010u\u001a\u0005\bu\u0010£\u0001R\u0018\u0010¤\u0001\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b¤\u0001\u0010\u007fR\"\u0010¦\u0001\u001a\u000b\u0012\u0004\u0012\u00020e\u0018\u00010¥\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¦\u0001\u0010§\u0001R\u0018\u0010©\u0001\u001a\u00030¨\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b©\u0001\u0010ª\u0001¨\u0006®\u0001"}, d2 = {"Lcom/stepos/ailauncher/common/permission/G;", "", "<init>", "()V", "Landroid/content/Context;", "context", "Lcom/stepos/ailauncher/common/permission/c;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Landroid/content/Context;)Lcom/stepos/ailauncher/common/permission/c;", "LY8/t;", "b0", "B", "", "v0", "()Z", "", "reason", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "(Ljava/lang/String;)V", "N", "(Landroid/content/Context;)Z", "fromFreshGrant", "q0", "(Landroid/content/Context;Z)V", "Landroid/view/View;", "ownerView", "o0", "(Landroid/content/Context;Landroid/view/View;)Ljava/lang/Object;", "", "permissions", "Lcom/stepos/ailauncher/common/permission/PermissionLaunchPolicy;", "launchPolicy", "Lkotlin/Function2;", "", "onResult", ExifInterface.GPS_DIRECTION_TRUE, "(Landroid/content/Context;Ljava/util/List;Lcom/stepos/ailauncher/common/permission/PermissionLaunchPolicy;Lp9/p;)V", "", "id", "Landroid/content/Intent;", "z", "(Landroid/content/Context;ILjava/util/List;)Landroid/content/Intent;", "Landroid/app/Activity;", "activity", "K0", "(Landroid/app/Activity;ILjava/util/List;)V", "Lcom/stepos/ailauncher/common/permission/e;", "host", "J0", "(Landroid/content/Context;Lcom/stepos/ailauncher/common/permission/e;ILjava/util/List;)V", "P", "Lkotlin/Function0;", "action", "p0", "(Lp9/a;)V", "Lcom/stepos/ailauncher/common/permission/PermissionProxyActivity;", "e0", "(Lcom/stepos/ailauncher/common/permission/PermissionProxyActivity;)V", "g0", "restoreOverlay", "w", "(Ljava/lang/String;Z)V", ExifInterface.LONGITUDE_WEST, "C", ExifInterface.LATITUDE_SOUTH, "requestId", "Q", "(I)Z", "D", "permission", "K", "(Landroid/content/Context;Ljava/lang/String;)Z", "Lcom/stepos/ailauncher/common/permission/PermScene;", HomeGestureEligibilityContract.EXTRA_SCENE, "R", "(Landroid/content/Context;Lcom/stepos/ailauncher/common/permission/PermScene;)Z", "M", "n0", "(Landroid/content/Context;)V", "O", "(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/Boolean;", "L", "(Landroid/content/Context;)Ljava/lang/Boolean;", "X", "deferred", "s0", "(Z)V", "onGranted", "Lkotlin/Function1;", "onDenied", ExifInterface.LONGITUDE_EAST, "(Landroid/content/Context;Lcom/stepos/ailauncher/common/permission/PermScene;Lcom/stepos/ailauncher/common/permission/PermissionLaunchPolicy;Lp9/a;Lp9/l;)V", "j0", "(Landroid/content/Context;Lcom/stepos/ailauncher/common/permission/PermScene;Lcom/stepos/ailauncher/common/permission/PermissionLaunchPolicy;Lp9/l;)V", "x0", "(Landroid/content/Context;Lcom/stepos/ailauncher/common/permission/PermScene;Landroid/view/View;)V", "titleRes", "messageRes", "onConfirm", "onDismissWithoutConfirm", "onDismiss", "Landroid/app/Dialog;", "w0", "(Landroid/content/Context;IILp9/a;Lp9/a;Lp9/a;Landroid/view/View;)Landroid/app/Dialog;", "result", "permanentlyDenied", "i0", "(ILjava/util/Map;Z)V", "d0", "(I)V", "TAG", "Ljava/lang/String;", "KEY_ONETIME_MIC_GUIDE_DISMISS_AT", "KEY_ONETIME_MIC_GUIDE_ACKED_LEGACY", "KEY_ONETIME_MIC_GUIDE_SHOWN_LEGACY", "", "ONETIME_GUIDE_COOLDOWN_MS", "J", "ONETIME_GUIDE_DELAY_MS", "FLAG_PERMISSION_ONE_TIME", "I", "Ljava/lang/Runnable;", "oneTimeGuideRunnable", "Ljava/lang/Runnable;", "oneTimeGuideDialog", "Landroid/app/Dialog;", "oneTimeGuideDeferred", "Z", "Lcom/stepos/ailauncher/common/permission/G$b;", "oneTimeGuidePending", "Lcom/stepos/ailauncher/common/permission/G$b;", "EXTRA_REQUEST_ID", "EXTRA_PERMISSIONS", "REQUEST_TIMEOUT_MS", "Landroid/os/Handler;", "mainHandler", "Landroid/os/Handler;", "Ljava/util/concurrent/atomic/AtomicInteger;", "requestIdGen", "Ljava/util/concurrent/atomic/AtomicInteger;", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/stepos/ailauncher/common/permission/G$c;", AuthSessionDto.STATUS_PENDING, "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/stepos/ailauncher/common/permission/G$a;", "overlayHook", "Lcom/stepos/ailauncher/common/permission/G$a;", "()Lcom/stepos/ailauncher/common/permission/G$a;", "t0", "(Lcom/stepos/ailauncher/common/permission/G$a;)V", "preferIndependentTaskOnce", "getPreferIndependentTaskOnce", "u0", "activeProxy", "Lcom/stepos/ailauncher/common/permission/PermissionProxyActivity;", "", "liveProxies", "Ljava/util/Set;", "Lcom/stepos/ailauncher/common/permission/M;", "afterUiClosed", "Lcom/stepos/ailauncher/common/permission/M;", UxipConstants.f30680s, "sessionGeneration", "()J", "sessionAbandoned", "Ljava/lang/ref/WeakReference;", "settingsGuideDialogRef", "Ljava/lang/ref/WeakReference;", "com/stepos/ailauncher/common/permission/G$f", "store", "Lcom/stepos/ailauncher/common/permission/G$f;", Const.INTENT_KEY_PKGNAME, "c", Const.INTENT_KEY_APIKEY, "permission_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class G {
    public static final String EXTRA_PERMISSIONS = "extra_permissions";
    public static final String EXTRA_REQUEST_ID = "extra_request_id";
    private static final int FLAG_PERMISSION_ONE_TIME = 65536;
    private static final String KEY_ONETIME_MIC_GUIDE_ACKED_LEGACY = "perm_onetime_mic_guide_acked";
    private static final String KEY_ONETIME_MIC_GUIDE_DISMISS_AT = "perm_onetime_mic_guide_cancel_at";
    private static final String KEY_ONETIME_MIC_GUIDE_SHOWN_LEGACY = "perm_onetime_mic_guide_shown";
    private static final long ONETIME_GUIDE_COOLDOWN_MS = 172800000;
    private static final long ONETIME_GUIDE_DELAY_MS = 600;
    private static final long REQUEST_TIMEOUT_MS = 120000;
    private static final String TAG = "PermissionManager";
    private static volatile PermissionProxyActivity activeProxy;
    private static volatile boolean oneTimeGuideDeferred;
    private static Dialog oneTimeGuideDialog;
    private static PendingOneTimeGuide oneTimeGuidePending;
    private static Runnable oneTimeGuideRunnable;
    private static volatile OverlayHook overlayHook;
    private static volatile boolean preferIndependentTaskOnce;
    private static volatile boolean sessionAbandoned;
    private static long sessionGeneration;
    private static WeakReference<Dialog> settingsGuideDialogRef;
    public static final G INSTANCE = new G();
    private static final Handler mainHandler = new Handler(Looper.getMainLooper());
    private static final AtomicInteger requestIdGen = new AtomicInteger(1);
    private static final ConcurrentHashMap<Integer, c> pending = new ConcurrentHashMap<>();
    private static final Set<PermissionProxyActivity> liveProxies = new LinkedHashSet();
    private static final M afterUiClosed = new M(new InterfaceC5063a() { // from class: com.stepos.ailauncher.common.permission.k
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return Boolean.valueOf(G.y());
        }
    });
    private static final f store = new f();

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0015\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/stepos/ailauncher/common/permission/G$a;", "", "Lkotlin/Function0;", "LY8/t;", "hide", "show", "<init>", "(Lp9/a;Lp9/a;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lp9/a;", Const.INTENT_KEY_APIKEY, "()Lp9/a;", Const.INTENT_KEY_PKGNAME, "permission_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.common.permission.G$a, reason: from toString */
    public static final /* data */ class OverlayHook {
        private final InterfaceC5063a<Y8.t> hide;
        private final InterfaceC5063a<Y8.t> show;

        public OverlayHook(InterfaceC5063a<Y8.t> hide, InterfaceC5063a<Y8.t> show) {
            kotlin.jvm.internal.p.i(hide, "hide");
            kotlin.jvm.internal.p.i(show, "show");
            this.hide = hide;
            this.show = show;
        }

        public final InterfaceC5063a<Y8.t> a() {
            return this.hide;
        }

        public final InterfaceC5063a<Y8.t> b() {
            return this.show;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OverlayHook)) {
                return false;
            }
            OverlayHook overlayHook = (OverlayHook) other;
            return kotlin.jvm.internal.p.d(this.hide, overlayHook.hide) && kotlin.jvm.internal.p.d(this.show, overlayHook.show);
        }

        public int hashCode() {
            return (this.hide.hashCode() * 31) + this.show.hashCode();
        }

        public String toString() {
            return "OverlayHook(hide=" + this.hide + ", show=" + this.show + ")";
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u000f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/stepos/ailauncher/common/permission/G$b;", "", "Landroid/content/Context;", "app", "", "fromFreshGrant", "<init>", "(Landroid/content/Context;Z)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Landroid/content/Context;", Const.INTENT_KEY_APIKEY, "()Landroid/content/Context;", "Z", Const.INTENT_KEY_PKGNAME, "()Z", "permission_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.common.permission.G$b, reason: from toString */
    public static final /* data */ class PendingOneTimeGuide {
        private final Context app;
        private final boolean fromFreshGrant;

        public PendingOneTimeGuide(Context app, boolean z10) {
            kotlin.jvm.internal.p.i(app, "app");
            this.app = app;
            this.fromFreshGrant = z10;
        }

        /* renamed from: a, reason: from getter */
        public final Context getApp() {
            return this.app;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getFromFreshGrant() {
            return this.fromFreshGrant;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PendingOneTimeGuide)) {
                return false;
            }
            PendingOneTimeGuide pendingOneTimeGuide = (PendingOneTimeGuide) other;
            return kotlin.jvm.internal.p.d(this.app, pendingOneTimeGuide.app) && this.fromFreshGrant == pendingOneTimeGuide.fromFreshGrant;
        }

        public int hashCode() {
            return (this.app.hashCode() * 31) + Boolean.hashCode(this.fromFreshGrant);
        }

        public String toString() {
            return "PendingOneTimeGuide(app=" + this.app + ", fromFreshGrant=" + this.fromFreshGrant + ")";
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u0001B5\u0012$\u0010\u0007\u001a \u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0002\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bR5\u0010\u0007\u001a \u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/stepos/ailauncher/common/permission/G$c;", "", "Lkotlin/Function2;", "", "", "", "LY8/t;", "callback", "Ljava/lang/Runnable;", "timeout", "<init>", "(Lp9/p;Ljava/lang/Runnable;)V", "Lp9/p;", Const.INTENT_KEY_APIKEY, "()Lp9/p;", "Ljava/lang/Runnable;", Const.INTENT_KEY_PKGNAME, "()Ljava/lang/Runnable;", "permission_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c {
        private final p9.p<Map<String, Boolean>, Boolean, Y8.t> callback;
        private final Runnable timeout;

        /* JADX WARN: Multi-variable type inference failed */
        public c(p9.p<? super Map<String, Boolean>, ? super Boolean, Y8.t> callback, Runnable timeout) {
            kotlin.jvm.internal.p.i(callback, "callback");
            kotlin.jvm.internal.p.i(timeout, "timeout");
            this.callback = callback;
            this.timeout = timeout;
        }

        public final p9.p<Map<String, Boolean>, Boolean, Y8.t> a() {
            return this.callback;
        }

        /* renamed from: b, reason: from getter */
        public final Runnable getTimeout() {
            return this.timeout;
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class d {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PermissionLaunchKind.values().length];
            try {
                iArr[PermissionLaunchKind.IN_HOST_TASK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PermissionLaunchKind.NEW_TASK_ANCHORED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/ailauncher/common/permission/G$e", "Lcom/stepos/ailauncher/common/permission/c;", "", "permission", "", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)Z", "permission_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class e implements InterfaceC3186c {
        final /* synthetic */ Context $app;

        public e(Context context) {
            this.$app = context;
        }

        @Override // com.stepos.ailauncher.common.permission.InterfaceC3186c
        public boolean a(String permission) {
            kotlin.jvm.internal.p.i(permission, "permission");
            return androidx.core.content.a.a(this.$app, permission) == 0;
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"com/stepos/ailauncher/common/permission/G$f", "Lcom/stepos/ailauncher/common/permission/a;", "", "key", "", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)Z", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;)V", "permission_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class f implements InterfaceC3184a {
        @Override // com.stepos.ailauncher.common.permission.InterfaceC3184a
        public boolean a(String key) {
            kotlin.jvm.internal.p.i(key, "key");
            return C5009a.g(C5009a.INSTANCE, key, false, false, 4, null);
        }

        public void b(String key) {
            kotlin.jvm.internal.p.i(key, "key");
            C5009a.y(C5009a.INSTANCE, key, true, false, 4, null);
        }
    }

    public static final void A0(Dialog dialog, View view) {
        dialog.dismiss();
    }

    public static final void B0(Ref$BooleanRef ref$BooleanRef, InterfaceC5063a interfaceC5063a, Dialog dialog, Context context, View view) {
        ref$BooleanRef.f34815a = true;
        if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
        dialog.dismiss();
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", context.getPackageName(), null));
        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        context.startActivity(intent);
    }

    public static final void C0(Dialog dialog, View view) {
        dialog.dismiss();
    }

    public static final void D0(View view) {
    }

    public static final void E0(Dialog dialog, Object obj, String str, Ref$BooleanRef ref$BooleanRef, InterfaceC5063a interfaceC5063a, InterfaceC5063a interfaceC5063a2, DialogInterface dialogInterface) {
        WeakReference<Dialog> weakReference = settingsGuideDialogRef;
        if ((weakReference != null ? weakReference.get() : null) == dialog) {
            settingsGuideDialogRef = null;
        }
        if (obj != null) {
            com.stepos.agentframework.chatui.panelui.f.INSTANCE.c(str);
        }
        if (!ref$BooleanRef.f34815a && interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
        if (interfaceC5063a2 != null) {
            interfaceC5063a2.invoke();
        }
    }

    public static /* synthetic */ void F(G g10, Context context, PermScene permScene, PermissionLaunchPolicy permissionLaunchPolicy, InterfaceC5063a interfaceC5063a, InterfaceC5074l interfaceC5074l, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            permissionLaunchPolicy = PermissionLaunchPolicy.AUTO;
        }
        PermissionLaunchPolicy permissionLaunchPolicy2 = permissionLaunchPolicy;
        if ((i10 & 16) != 0) {
            interfaceC5074l = new InterfaceC5074l() { // from class: com.stepos.ailauncher.common.permission.q
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return G.G(((Boolean) obj2).booleanValue());
                }
            };
        }
        g10.E(context, permScene, permissionLaunchPolicy2, interfaceC5063a, interfaceC5074l);
    }

    public static final boolean F0(Dialog dialog) {
        return dialog.isShowing();
    }

    public static final Y8.t G(boolean z10) {
        return Y8.t.f7040a;
    }

    public static final Y8.t G0(Dialog dialog) {
        dialog.dismiss();
        return Y8.t.f7040a;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final Y8.t H(java.lang.String r7, com.stepos.ailauncher.common.permission.PermScene r8, android.content.Context r9, p9.InterfaceC5063a r10, boolean r11, p9.InterfaceC5074l r12, java.util.Map r13, boolean r14) {
        /*
            java.lang.String r0 = "result"
            kotlin.jvm.internal.p.i(r13, r0)
            boolean r0 = r13.isEmpty()
            if (r0 != 0) goto L36
            java.util.Collection r13 = r13.values()
            java.lang.Iterable r13 = (java.lang.Iterable) r13
            boolean r0 = r13 instanceof java.util.Collection
            if (r0 == 0) goto L20
            r0 = r13
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L20
            goto L38
        L20:
            java.util.Iterator r13 = r13.iterator()
        L24:
            boolean r0 = r13.hasNext()
            if (r0 == 0) goto L38
            java.lang.Object r0 = r13.next()
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L24
        L36:
            r1 = r7
            goto L50
        L38:
            o6.a r1 = o6.C5009a.INSTANCE
            r5 = 4
            r6 = 0
            r3 = 0
            r4 = 0
            r2 = r7
            o6.C5009a.y(r1, r2, r3, r4, r5, r6)
            com.stepos.ailauncher.common.permission.PermScene r7 = com.stepos.ailauncher.common.permission.PermScene.MICROPHONE
            if (r8 != r7) goto L4c
            com.stepos.ailauncher.common.permission.G r7 = com.stepos.ailauncher.common.permission.G.INSTANCE
            r8 = 1
            r7.q0(r9, r8)
        L4c:
            r10.invoke()
            goto L73
        L50:
            if (r14 != 0) goto L5d
            if (r11 == 0) goto L5d
            o6.a r0 = o6.C5009a.INSTANCE
            r4 = 4
            r5 = 0
            r2 = 0
            r3 = 0
            o6.C5009a.y(r0, r1, r2, r3, r4, r5)
        L5d:
            if (r14 == 0) goto L6c
            if (r11 != 0) goto L6c
            com.stepos.ailauncher.common.permission.G$f r7 = com.stepos.ailauncher.common.permission.G.store
            r7.b(r1)
            java.lang.Boolean r7 = java.lang.Boolean.FALSE
            r12.invoke(r7)
            goto L73
        L6c:
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r14)
            r12.invoke(r7)
        L73:
            Y8.t r7 = Y8.t.f7040a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.common.permission.G.H(java.lang.String, com.stepos.ailauncher.common.permission.PermScene, android.content.Context, p9.a, boolean, p9.l, java.util.Map, boolean):Y8.t");
    }

    public static final boolean H0(com.stepos.agentframework.chatui.panelui.a aVar) {
        return aVar.b();
    }

    public static final boolean I0(com.stepos.agentframework.chatui.panelui.a aVar) {
        return aVar.a();
    }

    public static final void U(int i10) {
        if (pending.remove(Integer.valueOf(i10)) != null) {
            Log.w(TAG, "request " + i10 + " timed out without result, callback dropped");
            G g10 = INSTANCE;
            g10.W();
            x(g10, "timeout", false, 2, null);
        }
    }

    public static final Y8.t Y() {
        INSTANCE.V("go_settings");
        return Y8.t.f7040a;
    }

    public static final Y8.t Z() {
        if (!oneTimeGuideDeferred) {
            INSTANCE.V("cancel");
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t a0() {
        oneTimeGuideDialog = null;
        return Y8.t.f7040a;
    }

    public static final void c0(c cVar) {
        cVar.a().invoke(kotlin.collections.a.i(), Boolean.FALSE);
    }

    public static final void f0() {
        afterUiClosed.b();
    }

    public static final void h0(c cVar, Map map, boolean z10) {
        cVar.a().invoke(map, Boolean.valueOf(z10));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void k0(G g10, Context context, PermScene permScene, PermissionLaunchPolicy permissionLaunchPolicy, InterfaceC5074l interfaceC5074l, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            permissionLaunchPolicy = PermissionLaunchPolicy.AUTO;
        }
        if ((i10 & 8) != 0) {
            interfaceC5074l = new InterfaceC5074l() { // from class: com.stepos.ailauncher.common.permission.A
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return G.l0(((Boolean) obj2).booleanValue());
                }
            };
        }
        g10.j0(context, permScene, permissionLaunchPolicy, interfaceC5074l);
    }

    public static final Y8.t l0(boolean z10) {
        return Y8.t.f7040a;
    }

    public static final Y8.t m0(PermScene permScene, Context context, InterfaceC5074l interfaceC5074l, Map result, boolean z10) {
        boolean z11;
        kotlin.jvm.internal.p.i(result, "result");
        store.b(permScene.getOnceKey());
        if (result.isEmpty()) {
            z11 = false;
            break;
        }
        Collection collectionValues = result.values();
        if (!(collectionValues instanceof Collection) || !collectionValues.isEmpty()) {
            Iterator it = collectionValues.iterator();
            while (it.hasNext()) {
                if (!((Boolean) it.next()).booleanValue()) {
                    z11 = false;
                    break;
                }
            }
        }
        z11 = true;
        if (!z11) {
            Toast.makeText(context.getApplicationContext(), permScene.getDeniedToastRes(), 0).show();
        } else if (permScene == PermScene.MICROPHONE) {
            INSTANCE.q0(context, true);
        }
        interfaceC5074l.invoke(Boolean.valueOf(z11));
        return Y8.t.f7040a;
    }

    public static final void r0(Context context, boolean z10) {
        oneTimeGuideRunnable = null;
        G g10 = INSTANCE;
        kotlin.jvm.internal.p.f(context);
        g10.X(context, z10);
    }

    public static /* synthetic */ void x(G g10, String str, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = true;
        }
        g10.w(str, z10);
    }

    public static final boolean y() {
        return !INSTANCE.P();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Dialog y0(G g10, Context context, int i10, int i11, InterfaceC5063a interfaceC5063a, InterfaceC5063a interfaceC5063a2, InterfaceC5063a interfaceC5063a3, View view, int i12, Object obj) {
        if ((i12 & 8) != 0) {
            interfaceC5063a = null;
        }
        if ((i12 & 16) != 0) {
            interfaceC5063a2 = null;
        }
        if ((i12 & 32) != 0) {
            interfaceC5063a3 = null;
        }
        if ((i12 & 64) != 0) {
            view = null;
        }
        return g10.w0(context, i10, i11, interfaceC5063a, interfaceC5063a2, interfaceC5063a3, view);
    }

    public static /* synthetic */ void z0(G g10, Context context, PermScene permScene, View view, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            view = null;
        }
        g10.x0(context, permScene, view);
    }

    public final InterfaceC3186c A(Context context) {
        return new e(context.getApplicationContext());
    }

    public final void B() {
        C5009a c5009a = C5009a.INSTANCE;
        C5009a.y(c5009a, KEY_ONETIME_MIC_GUIDE_ACKED_LEGACY, false, false, 4, null);
        C5009a.E(c5009a, KEY_ONETIME_MIC_GUIDE_DISMISS_AT, 0L, false, 4, null);
        C5009a.y(c5009a, KEY_ONETIME_MIC_GUIDE_SHOWN_LEGACY, false, false, 4, null);
    }

    public final void C() {
        if (sessionAbandoned) {
            sessionAbandoned = false;
            Log.d(TAG, "clearSessionAbandoned");
        }
    }

    public final boolean D() {
        Dialog dialog;
        WeakReference<Dialog> weakReference = settingsGuideDialogRef;
        if (weakReference == null || (dialog = weakReference.get()) == null) {
            return false;
        }
        if (!dialog.isShowing()) {
            settingsGuideDialogRef = null;
            return false;
        }
        dialog.dismiss();
        settingsGuideDialogRef = null;
        return true;
    }

    public final void E(final Context context, final PermScene scene, PermissionLaunchPolicy launchPolicy, final InterfaceC5063a<Y8.t> onGranted, final InterfaceC5074l<? super Boolean, Y8.t> onDenied) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(scene, "scene");
        kotlin.jvm.internal.p.i(launchPolicy, "launchPolicy");
        kotlin.jvm.internal.p.i(onGranted, "onGranted");
        kotlin.jvm.internal.p.i(onDenied, "onDenied");
        if (sessionAbandoned) {
            Log.d(TAG, "ensure(" + scene.name() + "): skip, sessionAbandoned");
            return;
        }
        H h10 = H.INSTANCE;
        List<String> permissions = scene.getPermissions();
        SceneRequestMode sceneRequestMode = SceneRequestMode.ON_DEMAND;
        InterfaceC3186c interfaceC3186cA = A(context);
        f fVar = store;
        AbstractC3187d abstractC3187dA = h10.a(permissions, sceneRequestMode, null, interfaceC3186cA, fVar);
        if (kotlin.jvm.internal.p.d(abstractC3187dA, AbstractC3187d.a.INSTANCE)) {
            overlayHook = null;
            if (scene == PermScene.MICROPHONE) {
                q0(context, false);
            }
            onGranted.invoke();
            return;
        }
        if (!kotlin.jvm.internal.p.d(abstractC3187dA, AbstractC3187d.b.INSTANCE)) {
            if (!kotlin.jvm.internal.p.d(abstractC3187dA, AbstractC3187d.c.INSTANCE)) {
                throw new NoWhenBranchMatchedException();
            }
            overlayHook = null;
            onDenied.invoke(Boolean.FALSE);
            return;
        }
        final String str = "perm_permanently_denied_" + scene.name();
        final boolean zA = fVar.a(str);
        Log.d(TAG, "ensure(" + scene.name() + "): launching request, knownPermanent=" + zA);
        T(context, scene.getPermissions(), launchPolicy, new p9.p() { // from class: com.stepos.ailauncher.common.permission.B
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return G.H(str, scene, context, onGranted, zA, onDenied, (Map) obj, ((Boolean) obj2).booleanValue());
            }
        });
    }

    public final OverlayHook I() {
        return overlayHook;
    }

    public final long J() {
        return sessionGeneration;
    }

    public final void J0(Context context, PermissionHost host, int id, List<String> permissions) {
        Bundle bundleC;
        Intent intentZ = z(context, id, permissions);
        intentZ.addFlags(276824064);
        boolean z10 = preferIndependentTaskOnce;
        preferIndependentTaskOnce = false;
        if (host.e() || z10) {
            kotlin.jvm.internal.p.f(intentZ.addFlags(32768));
            bundleC = null;
        } else {
            bundleC = L.INSTANCE.c(host.getAnchorTaskId());
            if (bundleC == null) {
                Log.w(TAG, "overlay options failed, independent task fallback");
                intentZ.addFlags(32768);
            }
        }
        context.startActivity(intentZ, bundleC);
    }

    public final boolean K(Context context, String permission) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(permission, "permission");
        return A(context).a(permission);
    }

    public final void K0(Activity activity, int id, List<String> permissions) {
        Intent intentZ = z(activity, id, permissions);
        intentZ.addFlags(8388608);
        activity.startActivity(intentZ);
    }

    public final Boolean L(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        return O(context, PolicySdkPermissionManifestUtils.RECORD_AUDIO);
    }

    public final boolean M(Context context, PermScene scene) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(scene, "scene");
        return R(context, scene) || store.a(scene.getOnceKey());
    }

    public final boolean N(Context context) {
        ActivityManager activityManager;
        String packageName;
        if (!com.stepos.ailauncher.common.privacy.b.INSTANCE.b()) {
            return false;
        }
        try {
            Object systemService = context.getSystemService("activity");
            activityManager = systemService instanceof ActivityManager ? (ActivityManager) systemService : null;
        } catch (Throwable th) {
            Log.w(TAG, "isOverlayingExternalApp failed: " + th.getMessage());
        }
        if (activityManager == null) {
            return false;
        }
        String packageName2 = context.getPackageName();
        List<ActivityManager.RunningTaskInfo> runningTasks = activityManager.getRunningTasks(8);
        if (runningTasks == null) {
            runningTasks = C1173v.m();
        }
        for (ActivityManager.RunningTaskInfo runningTaskInfo : runningTasks) {
            ComponentName componentName = runningTaskInfo.topActivity;
            if (componentName == null || (packageName = componentName.getPackageName()) == null) {
                ComponentName componentName2 = runningTaskInfo.baseActivity;
                packageName = componentName2 != null ? componentName2.getPackageName() : null;
                if (packageName == null) {
                }
            }
            if (!kotlin.jvm.internal.p.d(packageName, packageName2)) {
                if (K.INSTANCE.d(context, packageName)) {
                    Log.d(TAG, "isOverlayingExternalApp: under launcher pkg=" + packageName);
                    return false;
                }
                Log.d(TAG, "isOverlayingExternalApp: under external pkg=" + packageName);
                return true;
            }
        }
        Log.d(TAG, "isOverlayingExternalApp: no external task found");
        return false;
    }

    public final Boolean O(Context context, String permission) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(permission, "permission");
        if (!K(context, permission)) {
            return Boolean.FALSE;
        }
        try {
            Object objInvoke = PackageManager.class.getMethod("getPermissionFlags", String.class, String.class, UserHandle.class).invoke(context.getPackageManager(), permission, context.getPackageName(), Process.myUserHandle());
            kotlin.jvm.internal.p.g(objInvoke, "null cannot be cast to non-null type kotlin.Int");
            return Boolean.valueOf((((Integer) objInvoke).intValue() & 65536) != 0);
        } catch (Throwable th) {
            th = th;
            Throwable cause = th.getCause();
            if (cause != null) {
                th = cause;
            }
            Log.w(TAG, "isPermissionOneTime(" + permission + ") failed: " + th.getMessage());
            return null;
        }
    }

    public final boolean P() {
        return (pending.isEmpty() && liveProxies.isEmpty()) ? false : true;
    }

    public final boolean Q(int requestId) {
        return pending.containsKey(Integer.valueOf(requestId));
    }

    public final boolean R(Context context, PermScene scene) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(scene, "scene");
        InterfaceC3186c interfaceC3186cA = A(context);
        List<String> permissions = scene.getPermissions();
        if ((permissions instanceof Collection) && permissions.isEmpty()) {
            return true;
        }
        Iterator<T> it = permissions.iterator();
        while (it.hasNext()) {
            if (!interfaceC3186cA.a((String) it.next())) {
                return false;
            }
        }
        return true;
    }

    public final boolean S() {
        return sessionAbandoned;
    }

    public final void T(Context context, List<String> permissions, PermissionLaunchPolicy launchPolicy, p9.p<? super Map<String, Boolean>, ? super Boolean, Y8.t> onResult) {
        InterfaceC5063a<Y8.t> interfaceC5063aB;
        InterfaceC5063a<Y8.t> interfaceC5063aA;
        w("before-launch", false);
        final int andIncrement = requestIdGen.getAndIncrement();
        Runnable runnable = new Runnable() { // from class: com.stepos.ailauncher.common.permission.s
            @Override // java.lang.Runnable
            public final void run() {
                G.U(andIncrement);
            }
        };
        pending.put(Integer.valueOf(andIncrement), new c(onResult, runnable));
        mainHandler.postDelayed(runnable, REQUEST_TIMEOUT_MS);
        PermissionHost permissionHostK = C3193j.INSTANCE.k(context, launchPolicy);
        Log.i(TAG, "launchRequest id=" + andIncrement + " kind=" + permissionHostK.getKind() + " scene=" + permissionHostK.getUiScene() + " anchor=" + permissionHostK.getAnchorTaskId() + " independent=" + permissionHostK.e() + " policy=" + launchPolicy);
        OverlayHook overlayHook2 = overlayHook;
        if (overlayHook2 != null && (interfaceC5063aA = overlayHook2.a()) != null) {
            interfaceC5063aA.invoke();
        }
        try {
            int i10 = d.$EnumSwitchMapping$0[permissionHostK.getKind().ordinal()];
            if (i10 != 1) {
                if (i10 != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                J0(context, permissionHostK, andIncrement, permissions);
            } else {
                Activity activity = permissionHostK.getActivity();
                kotlin.jvm.internal.p.f(activity);
                K0(activity, andIncrement, permissions);
            }
        } catch (Throwable th) {
            Log.e(TAG, "launchRequest startActivity failed kind=" + permissionHostK.getKind(), th);
            c cVarRemove = pending.remove(Integer.valueOf(andIncrement));
            if (cVarRemove != null) {
                mainHandler.removeCallbacks(cVarRemove.getTimeout());
            }
            W();
            OverlayHook overlayHook3 = overlayHook;
            if (overlayHook3 != null && (interfaceC5063aB = overlayHook3.b()) != null) {
                interfaceC5063aB.invoke();
            }
            overlayHook = null;
        }
    }

    public final void V(String reason) {
        C5009a c5009a = C5009a.INSTANCE;
        C5009a.E(c5009a, KEY_ONETIME_MIC_GUIDE_DISMISS_AT, System.currentTimeMillis(), false, 4, null);
        C5009a.y(c5009a, KEY_ONETIME_MIC_GUIDE_ACKED_LEGACY, false, false, 4, null);
        Log.i(TAG, "oneTimeMicGuide: dismissed reason=" + reason + ", cooldown 172800000ms");
    }

    public final void W() {
        sessionAbandoned = true;
        sessionGeneration++;
        afterUiClosed.a();
        Runnable runnable = oneTimeGuideRunnable;
        if (runnable != null) {
            mainHandler.removeCallbacks(runnable);
        }
        oneTimeGuideRunnable = null;
        Log.i(TAG, "markSessionAbandoned");
    }

    public final void X(Context context, boolean fromFreshGrant) {
        kotlin.jvm.internal.p.i(context, "context");
        Context applicationContext = context.getApplicationContext();
        b0();
        kotlin.jvm.internal.p.f(applicationContext);
        Boolean boolL = L(applicationContext);
        if (kotlin.jvm.internal.p.d(boolL, Boolean.FALSE)) {
            B();
            oneTimeGuidePending = null;
            return;
        }
        if (kotlin.jvm.internal.p.d(boolL, Boolean.TRUE)) {
            if (v0()) {
                Log.d(TAG, "maybeGuideMicrophoneOneTime: skip, frequency control");
                oneTimeGuidePending = null;
                return;
            }
        } else {
            if (boolL != null) {
                throw new NoWhenBranchMatchedException();
            }
            if (!fromFreshGrant) {
                Log.d(TAG, "maybeGuideMicrophoneOneTime: skip, detect unknown");
                return;
            } else {
                if (v0()) {
                    Log.d(TAG, "maybeGuideMicrophoneOneTime: skip fallback, frequency control");
                    oneTimeGuidePending = null;
                    return;
                }
                Log.w(TAG, "maybeGuideMicrophoneOneTime: detect unknown, may show on fresh grant fallback");
            }
        }
        if (oneTimeGuideDeferred) {
            oneTimeGuidePending = new PendingOneTimeGuide(applicationContext, fromFreshGrant);
            Log.d(TAG, "maybeGuideMicrophoneOneTime: deferred fromFreshGrant=" + fromFreshGrant);
            return;
        }
        if (!N(applicationContext)) {
            Log.d(TAG, "maybeGuideMicrophoneOneTime: skip, not over external app");
            return;
        }
        if (oneTimeGuideDialog != null) {
            Log.d(TAG, "maybeGuideMicrophoneOneTime: skip, dialog already showing");
            return;
        }
        Log.i(TAG, "maybeGuideMicrophoneOneTime: show guide fromFreshGrant=" + fromFreshGrant);
        try {
            oneTimeGuideDialog = y0(this, applicationContext, R$string.perm_guide_title_microphone_onetime, R$string.perm_guide_message_microphone_onetime, new InterfaceC5063a() { // from class: com.stepos.ailauncher.common.permission.u
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return G.Y();
                }
            }, new InterfaceC5063a() { // from class: com.stepos.ailauncher.common.permission.w
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return G.Z();
                }
            }, new InterfaceC5063a() { // from class: com.stepos.ailauncher.common.permission.x
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return G.a0();
                }
            }, null, 64, null);
        } catch (Throwable th) {
            oneTimeGuideDialog = null;
            Log.w(TAG, "maybeGuideMicrophoneOneTime: show failed: " + th.getMessage());
        }
    }

    public final void b0() {
        C5009a c5009a = C5009a.INSTANCE;
        if (C5009a.g(c5009a, KEY_ONETIME_MIC_GUIDE_ACKED_LEGACY, false, false, 4, null)) {
            if (C5009a.o(c5009a, KEY_ONETIME_MIC_GUIDE_DISMISS_AT, 0L, false, 4, null) <= 0) {
                C5009a.E(c5009a, KEY_ONETIME_MIC_GUIDE_DISMISS_AT, System.currentTimeMillis(), false, 4, null);
            }
            C5009a.y(c5009a, KEY_ONETIME_MIC_GUIDE_ACKED_LEGACY, false, false, 4, null);
        }
        if (C5009a.g(c5009a, KEY_ONETIME_MIC_GUIDE_SHOWN_LEGACY, false, false, 4, null)) {
            if (C5009a.o(c5009a, KEY_ONETIME_MIC_GUIDE_DISMISS_AT, 0L, false, 4, null) <= 0) {
                C5009a.E(c5009a, KEY_ONETIME_MIC_GUIDE_DISMISS_AT, System.currentTimeMillis(), false, 4, null);
            }
            C5009a.y(c5009a, KEY_ONETIME_MIC_GUIDE_SHOWN_LEGACY, false, false, 4, null);
        }
    }

    public final void d0(int requestId) {
        InterfaceC5063a<Y8.t> interfaceC5063aB;
        final c cVarRemove = pending.remove(Integer.valueOf(requestId));
        if (cVarRemove != null) {
            W();
            Handler handler = mainHandler;
            handler.removeCallbacks(cVarRemove.getTimeout());
            Log.d(TAG, "request " + requestId + " cancelled → deny callback");
            handler.post(new Runnable() { // from class: com.stepos.ailauncher.common.permission.z
                @Override // java.lang.Runnable
                public final void run() {
                    G.c0(cVarRemove);
                }
            });
            OverlayHook overlayHook2 = overlayHook;
            if (overlayHook2 != null && (interfaceC5063aB = overlayHook2.b()) != null) {
                interfaceC5063aB.invoke();
            }
            overlayHook = null;
        }
    }

    public final void e0(PermissionProxyActivity activity) {
        kotlin.jvm.internal.p.i(activity, "activity");
        activeProxy = activity;
        liveProxies.add(activity);
    }

    public final void g0(PermissionProxyActivity activity) {
        kotlin.jvm.internal.p.i(activity, "activity");
        if (activeProxy == activity) {
            activeProxy = null;
        }
        liveProxies.remove(activity);
        mainHandler.post(new Runnable() { // from class: com.stepos.ailauncher.common.permission.v
            @Override // java.lang.Runnable
            public final void run() {
                G.f0();
            }
        });
    }

    public final void i0(int requestId, final Map<String, Boolean> result, final boolean permanentlyDenied) {
        kotlin.jvm.internal.p.i(result, "result");
        final c cVarRemove = pending.remove(Integer.valueOf(requestId));
        if (cVarRemove == null) {
            return;
        }
        Handler handler = mainHandler;
        handler.removeCallbacks(cVarRemove.getTimeout());
        handler.post(new Runnable() { // from class: com.stepos.ailauncher.common.permission.y
            @Override // java.lang.Runnable
            public final void run() {
                G.h0(cVarRemove, result, permanentlyDenied);
            }
        });
    }

    public final void j0(final Context context, final PermScene scene, PermissionLaunchPolicy launchPolicy, final InterfaceC5074l<? super Boolean, Y8.t> onResult) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(scene, "scene");
        kotlin.jvm.internal.p.i(launchPolicy, "launchPolicy");
        kotlin.jvm.internal.p.i(onResult, "onResult");
        if (sessionAbandoned) {
            Log.d(TAG, "requestOnceIfNeeded(" + scene.name() + "): skip, sessionAbandoned");
            return;
        }
        AbstractC3187d abstractC3187dA = H.INSTANCE.a(scene.getPermissions(), SceneRequestMode.ONCE, scene.getOnceKey(), A(context), store);
        if (kotlin.jvm.internal.p.d(abstractC3187dA, AbstractC3187d.a.INSTANCE)) {
            overlayHook = null;
            Log.d(TAG, "requestOnceIfNeeded(" + scene.name() + "): already granted, skip");
            onResult.invoke(Boolean.TRUE);
            return;
        }
        if (kotlin.jvm.internal.p.d(abstractC3187dA, AbstractC3187d.c.INSTANCE)) {
            overlayHook = null;
            Log.d(TAG, "requestOnceIfNeeded(" + scene.name() + "): already asked, skip");
            onResult.invoke(Boolean.FALSE);
            return;
        }
        if (!kotlin.jvm.internal.p.d(abstractC3187dA, AbstractC3187d.b.INSTANCE)) {
            throw new NoWhenBranchMatchedException();
        }
        Log.d(TAG, "requestOnceIfNeeded(" + scene.name() + "): launching request");
        T(context, scene.getPermissions(), launchPolicy, new p9.p() { // from class: com.stepos.ailauncher.common.permission.r
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return G.m0(scene, context, onResult, (Map) obj, ((Boolean) obj2).booleanValue());
            }
        });
    }

    public final void n0(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        Log.d(TAG, "[PERM-DIAG] resetAllPermissionState: clearing app user data");
        Object systemService = context.getSystemService("activity");
        ActivityManager activityManager = systemService instanceof ActivityManager ? (ActivityManager) systemService : null;
        Log.d(TAG, "[PERM-DIAG] resetAllPermissionState: clearApplicationUserData=" + (activityManager != null ? activityManager.clearApplicationUserData() : false));
    }

    public final Object o0(Context context, View ownerView) {
        View decorView;
        View rootView;
        View rootView2;
        if (ownerView != null && (rootView2 = ownerView.getRootView()) != null) {
            return rootView2;
        }
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                Window window = ((Activity) context).getWindow();
                return (window == null || (decorView = window.getDecorView()) == null || (rootView = decorView.getRootView()) == null) ? context : rootView;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return null;
    }

    public final void p0(InterfaceC5063a<Y8.t> action) {
        kotlin.jvm.internal.p.i(action, "action");
        afterUiClosed.c(action);
    }

    public final void q0(Context context, final boolean fromFreshGrant) {
        final Context applicationContext = context.getApplicationContext();
        Runnable runnable = oneTimeGuideRunnable;
        if (runnable != null) {
            mainHandler.removeCallbacks(runnable);
        }
        Runnable runnable2 = new Runnable() { // from class: com.stepos.ailauncher.common.permission.t
            @Override // java.lang.Runnable
            public final void run() {
                G.r0(applicationContext, fromFreshGrant);
            }
        };
        oneTimeGuideRunnable = runnable2;
        mainHandler.postDelayed(runnable2, ONETIME_GUIDE_DELAY_MS);
    }

    public final void s0(boolean deferred) {
        Object objB;
        if (!deferred) {
            if (oneTimeGuideDeferred || oneTimeGuidePending != null) {
                oneTimeGuideDeferred = false;
                PendingOneTimeGuide pendingOneTimeGuide = oneTimeGuidePending;
                if (pendingOneTimeGuide == null) {
                    return;
                }
                oneTimeGuidePending = null;
                q0(pendingOneTimeGuide.getApp(), pendingOneTimeGuide.getFromFreshGrant());
                return;
            }
            return;
        }
        if (oneTimeGuideDeferred) {
            return;
        }
        oneTimeGuideDeferred = true;
        Dialog dialog = oneTimeGuideDialog;
        if (dialog != null) {
            if (oneTimeGuidePending == null) {
                Context applicationContext = dialog.getContext().getApplicationContext();
                kotlin.jvm.internal.p.h(applicationContext, "getApplicationContext(...)");
                oneTimeGuidePending = new PendingOneTimeGuide(applicationContext, true);
            }
            try {
                Result.Companion companion = Result.INSTANCE;
                dialog.dismiss();
                objB = Result.b(Y8.t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            Result.a(objB);
        }
    }

    public final void t0(OverlayHook overlayHook2) {
        overlayHook = overlayHook2;
    }

    public final void u0(boolean z10) {
        preferIndependentTaskOnce = z10;
    }

    public final boolean v0() {
        long jO = C5009a.o(C5009a.INSTANCE, KEY_ONETIME_MIC_GUIDE_DISMISS_AT, 0L, false, 4, null);
        if (jO <= 0) {
            return false;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - jO;
        return 0 <= jCurrentTimeMillis && jCurrentTimeMillis < 172800000;
    }

    public final void w(String reason, boolean restoreOverlay) {
        InterfaceC5063a<Y8.t> interfaceC5063aB;
        kotlin.jvm.internal.p.i(reason, "reason");
        ConcurrentHashMap<Integer, c> concurrentHashMap = pending;
        if (concurrentHashMap.isEmpty() && activeProxy == null && (!restoreOverlay || overlayHook == null)) {
            return;
        }
        int size = concurrentHashMap.size();
        Set<Integer> setKeySet = concurrentHashMap.keySet();
        kotlin.jvm.internal.p.h(setKeySet, "<get-keys>(...)");
        for (Object obj : Z8.F.m1(setKeySet)) {
            kotlin.jvm.internal.p.h(obj, "next(...)");
            c cVarRemove = pending.remove(Integer.valueOf(((Number) obj).intValue()));
            if (cVarRemove != null) {
                mainHandler.removeCallbacks(cVarRemove.getTimeout());
            }
        }
        PermissionProxyActivity permissionProxyActivity = activeProxy;
        if (permissionProxyActivity != null && !permissionProxyActivity.isFinishing()) {
            Log.i(TAG, "abandonPendingRequests(" + reason + "): finish proxy + drop " + size + " pending restoreOverlay=" + restoreOverlay);
            permissionProxyActivity.finish();
        } else if (size > 0) {
            Log.i(TAG, "abandonPendingRequests(" + reason + "): drop " + size + " pending (no proxy)");
        }
        if (restoreOverlay) {
            OverlayHook overlayHook2 = overlayHook;
            if (overlayHook2 != null && (interfaceC5063aB = overlayHook2.b()) != null) {
                interfaceC5063aB.invoke();
            }
            overlayHook = null;
        }
    }

    public final Dialog w0(Context context, int titleRes, int messageRes, final InterfaceC5063a<Y8.t> onConfirm, final InterfaceC5063a<Y8.t> onDismissWithoutConfirm, final InterfaceC5063a<Y8.t> onDismiss, View ownerView) {
        Dialog dialog;
        kotlin.jvm.internal.p.i(context, "context");
        final Context applicationContext = context.getApplicationContext();
        final Object objO0 = o0(context, ownerView);
        final Dialog dialog2 = new Dialog(applicationContext, R.style.Theme.Translucent.NoTitleBar);
        com.stepos.ailauncher.container.dialog.f.h(dialog2.getWindow(), applicationContext);
        Window window = dialog2.getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(R.color.transparent);
            window.setLayout(-1, -1);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(0);
            window.setNavigationBarColor(0);
        }
        dialog2.setCancelable(true);
        dialog2.setCanceledOnTouchOutside(true);
        View viewInflate = LayoutInflater.from(applicationContext).inflate(R$layout.dialog_permission_guide, (ViewGroup) null);
        dialog2.setContentView(viewInflate);
        final Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        ((TextView) viewInflate.findViewById(R$id.tv_title)).setText(titleRes);
        ((TextView) viewInflate.findViewById(R$id.tv_message)).setText(messageRes);
        TextView textView = (TextView) viewInflate.findViewById(R$id.btn_cancel);
        textView.setText(R$string.perm_guide_btn_cancel);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.common.permission.C
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                G.A0(dialog2, view);
            }
        });
        TextView textView2 = (TextView) viewInflate.findViewById(R$id.btn_confirm);
        textView2.setText(R$string.perm_guide_btn_confirm);
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.common.permission.D
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                G.B0(ref$BooleanRef, onConfirm, dialog2, applicationContext, view);
            }
        });
        View viewFindViewById = viewInflate.findViewById(R$id.fl_overlay);
        if (viewFindViewById != null) {
            viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.common.permission.E
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    G.C0(dialog2, view);
                }
            });
        }
        View viewFindViewById2 = viewInflate.findViewById(R$id.ll_card);
        if (viewFindViewById2 != null) {
            viewFindViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.common.permission.F
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    G.D0(view);
                }
            });
        }
        final String str = "perm_guide_" + System.identityHashCode(dialog2);
        final com.stepos.agentframework.chatui.panelui.a aVar = new com.stepos.agentframework.chatui.panelui.a(dialog2);
        dialog2.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.stepos.ailauncher.common.permission.l
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                G.E0(dialog2, objO0, str, ref$BooleanRef, onDismissWithoutConfirm, onDismiss, dialogInterface);
            }
        });
        if (!com.stepos.ailauncher.container.dialog.f.q(dialog2, "permGuide")) {
            if (onDismissWithoutConfirm != null) {
                onDismissWithoutConfirm.invoke();
            }
            if (onDismiss != null) {
                onDismiss.invoke();
            }
            return null;
        }
        WeakReference<Dialog> weakReference = settingsGuideDialogRef;
        if (weakReference != null && (dialog = weakReference.get()) != null) {
            dialog.dismiss();
        }
        settingsGuideDialogRef = new WeakReference<>(dialog2);
        if (objO0 != null) {
            com.stepos.agentframework.chatui.panelui.f.INSTANCE.b(str, PanelHomePolicy.DISMISS_TOP_ONLY, objO0, new InterfaceC5063a() { // from class: com.stepos.ailauncher.common.permission.m
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return Boolean.valueOf(G.F0(dialog2));
                }
            }, new InterfaceC5063a() { // from class: com.stepos.ailauncher.common.permission.n
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return G.G0(dialog2);
                }
            }, new InterfaceC5063a() { // from class: com.stepos.ailauncher.common.permission.o
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return Boolean.valueOf(G.H0(aVar));
                }
            }, new InterfaceC5063a() { // from class: com.stepos.ailauncher.common.permission.p
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return Boolean.valueOf(G.I0(aVar));
                }
            });
        }
        return dialog2;
    }

    public final void x0(Context context, PermScene scene, View ownerView) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(scene, "scene");
        y0(this, context, scene.getGuideTitleRes(), scene.getGuideMessageRes(), null, null, null, ownerView, 56, null);
    }

    public final Intent z(Context context, int id, List<String> permissions) {
        Intent intent = new Intent(context, (Class<?>) PermissionProxyActivity.class);
        intent.putExtra("extra_request_id", id);
        intent.putExtra(EXTRA_PERMISSIONS, (String[]) permissions.toArray(new String[0]));
        return intent;
    }
}
