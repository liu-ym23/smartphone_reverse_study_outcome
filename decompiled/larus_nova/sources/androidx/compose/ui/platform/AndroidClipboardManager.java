package androidx.compose.ui.platform;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Context;
import android.os.Build;
import androidx.compose.ui.text.AnnotatedString;
import com.bytedance.bpea.entry.common.DataType;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0010\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0012\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0011H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0014\u001a\u00060\u0003j\u0002`\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Landroidx/compose/ui/platform/AndroidClipboardManager;", "Landroidx/compose/ui/platform/ClipboardManager;", "clipboardManager", "Landroid/content/ClipboardManager;", "<init>", "(Landroid/content/ClipboardManager;)V", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "(Landroid/content/Context;)V", "setText", "", "annotatedString", "Landroidx/compose/ui/text/AnnotatedString;", "getText", "hasText", "", "getClip", "Landroidx/compose/ui/platform/ClipEntry;", "setClip", "clipEntry", "nativeClipboard", "Landroidx/compose/ui/platform/NativeClipboard;", "getNativeClipboard", "()Landroid/content/ClipboardManager;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AndroidClipboardManager implements ClipboardManager {
    public static final int $stable = 8;
    private final android.content.ClipboardManager clipboardManager;

    @Override // androidx.compose.ui.platform.ClipboardManager
    public ClipEntry getClip() {
        ClipData r100 = androidx_compose_ui_platform_AndroidClipboardManager_android_content_ClipboardManager_getPrimaryClip(this.clipboardManager);
        if (r100 != null) goto L7;
        return null;
    L7:
        return new ClipEntry(r100);
    }

    @Override // androidx.compose.ui.platform.ClipboardManager
    public AnnotatedString getText() {
        ClipData r100 = androidx_compose_ui_platform_AndroidClipboardManager_android_content_ClipboardManager_getPrimaryClip(this.clipboardManager);
        CharSequence r101 = null;
        if (r100 != null) goto L5;
        return null;
    L5:
        if (r100.getItemCount() <= 0) goto L12;
        ClipData.Item r102 = r100.getItemAt(0);
        if (r102 == null) goto L10;
        r101 = r102.getText();
    L10:
        return AndroidClipboardManager_androidKt.convertToAnnotatedString(r101);
    L12:
        return null;
    }

    @Override // androidx.compose.ui.platform.ClipboardManager
    public boolean hasText() {
        ClipDescription r100 = androidx_compose_ui_platform_AndroidClipboardManager_android_content_ClipboardManager_getPrimaryClipDescription(this.clipboardManager);
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.hasMimeType("text/*");
    }

    @Override // androidx.compose.ui.platform.ClipboardManager
    public android.content.ClipboardManager getNativeClipboard() {
        return this.clipboardManager;
    }

    public AndroidClipboardManager(Context r100) {
        Object r101 = r100.getSystemService(DataType.CLIPBOARD);
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type android.content.ClipboardManager");
        this((android.content.ClipboardManager) r101);
    }

    private static ClipData androidx_compose_ui_platform_AndroidClipboardManager_android_content_ClipboardManager_getPrimaryClip(android.content.ClipboardManager r110) {
        f06.c r100 = new f06.c();
        Object[] r101 = new Object[0];
        f06.b r111 = new f06.b();
        f06.d r112 = r100.b(101803, "android/content/ClipboardManager", "getPrimaryClip", r110, r101, "android.content.ClipData", r111);
        if (r112.f474982a == false) goto L6;
        r100.a(101803, "android/content/ClipboardManager", "getPrimaryClip", r110, r101, null, r111, false);
        return (ClipData) r112.f474983b;
    L6:
        ClipData r113 = r110.getPrimaryClip();
        r100.a(101803, "android/content/ClipboardManager", "getPrimaryClip", r110, r101, r113, r111, true);
        return r113;
    }

    private static ClipDescription androidx_compose_ui_platform_AndroidClipboardManager_android_content_ClipboardManager_getPrimaryClipDescription(android.content.ClipboardManager r110) {
        ArrayList r100 = new ArrayList();
        Object[] r111 = new Object[0];
        f06.b r112 = new f06.b();
        g06.a r101 = ApiHookConfig.f245611b.get(101809);
        if (r101 == null) goto L5;
        f06.a[] r102 = r101.f479473i;
    L6:
        f06.a[] r113 = r102;
        int r103 = r113.length;
        int r104 = 0;
    L8:
        if (r104 >= r103) goto L15;
        f06.a r105 = r113[r104];
        int r114 = r104;
        int r115 = r103;
        f06.d r106 = r105.preInvoke(101809, "android/content/ClipboardManager", "getPrimaryClipDescription", r110, r111, "android.content.ClipDescription", r112);     // Catch: Exception -> L22
        if (r106.f474982a == true) goto L17;
        r100.add(r105);     // Catch: Exception -> L22
    L17:
        if (r106.f474982a == false) goto L21;
        return (ClipDescription) r106.f474983b;
    L21:
        return r110.getPrimaryClipDescription();
    L14:
        r104 = r114 + 1;
        r103 = r115;
        goto L8
    L15:
        r106 = new f06.d(false, null);
        goto L17
    L5:
        r102 = ApiHookConfig.f245613d;
        goto L6
    }

    @Override // androidx.compose.ui.platform.ClipboardManager
    public void setClip(ClipEntry r100) {
        if (r100 == null) goto L4;
        INVOKEVIRTUAL_androidx_compose_ui_platform_AndroidClipboardManager_com_larus_home_impl_utils_ClipboardManagerLancet_setPrimaryClip(this.clipboardManager, r100.getClipData());
        return;
    L4:
        if (Build.VERSION.SDK_INT < 28) goto L6;
        Api28ClipboardManagerClipClear.clearPrimaryClip(this.clipboardManager);
        return;
    L6:
        INVOKEVIRTUAL_androidx_compose_ui_platform_AndroidClipboardManager_com_larus_home_impl_utils_ClipboardManagerLancet_setPrimaryClip(this.clipboardManager, ClipData.newPlainText("", ""));
    }

    @Override // androidx.compose.ui.platform.ClipboardManager
    public void setText(AnnotatedString r100) {
        INVOKEVIRTUAL_androidx_compose_ui_platform_AndroidClipboardManager_com_larus_home_impl_utils_ClipboardManagerLancet_setPrimaryClip(this.clipboardManager, ClipData.newPlainText("plain text", AndroidClipboardManager_androidKt.convertToCharSequence(r100)));
    }

    public AndroidClipboardManager(android.content.ClipboardManager r100) {
        this.clipboardManager = r100;
    }

    @Skip({"com.bytedance.timonbase.clipboard.ClipboardMonitorManager", "com.bytedance.timon.clipboard.suite.TimonClipboardSuite", "com.bytedance.timon.clipboard.suite.TimonClipboardSuiteKt"})
    public static void INVOKEVIRTUAL_androidx_compose_ui_platform_AndroidClipboardManager_com_larus_home_impl_utils_ClipboardManagerLancet_setPrimaryClip(android.content.ClipboardManager r100, ClipData r101) {
        Intrinsics.checkNotNullParameter(r101, "clip");
        FLogger.f375446a.i("ClipboardManagerLancet", "hook setPrimaryClip");     // Catch: Exception -> L5
        androidx_compose_ui_platform_AndroidClipboardManager_android_content_ClipboardManager_setPrimaryClip(r100, r101);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        com.larus.platform.service.g.f365738a.ensureNotReachHere(e, "setPrimaryClip Exception:");
        FLogger.f375446a.e("ClipboardManagerLancet", "setPrimaryClip Exception: " + e.getMessage());
    }

    private static void androidx_compose_ui_platform_AndroidClipboardManager_android_content_ClipboardManager_setPrimaryClip(android.content.ClipboardManager r110, ClipData r111) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111};
        f06.b r112 = new f06.b();
        g06.a r102 = ApiHookConfig.f245611b.get(101807);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r113 = r103;
        int r104 = r113.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r113[r105];
        int r114 = r105;
        int r115 = r104;
        f06.d r107 = r106.preInvoke(101807, "android/content/ClipboardManager", "setPrimaryClip", r110, r101, "void", r112);     // Catch: Exception -> L21
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L21
    L17:
        if (r107.f474982a == false) goto L19;
        return;
    L19:
        r110.setPrimaryClip(r111);
        return;
    L14:
        r105 = r114 + 1;
        r104 = r115;
        goto L8
    L15:
        r107 = new f06.d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }
}
