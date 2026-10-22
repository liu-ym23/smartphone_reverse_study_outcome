package androidx.compose.ui.text.intl;

import androidx.compose.ui.text.platform.SynchronizedObject;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\r\u001a\u00060\u000ej\u0002`\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/text/intl/AndroidLocaleDelegateAPI24;", "Landroidx/compose/ui/text/intl/PlatformLocaleDelegate;", "<init>", "()V", "lastPlatformLocaleList", "Landroid/os/LocaleList;", "lastLocaleList", "Landroidx/compose/ui/text/intl/LocaleList;", "lock", "Landroidx/compose/ui/text/platform/SynchronizedObject;", "current", "getCurrent", "()Landroidx/compose/ui/text/intl/LocaleList;", "parseLanguageTag", "Ljava/util/Locale;", "Landroidx/compose/ui/text/intl/PlatformLocale;", "languageTag", "", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AndroidLocaleDelegateAPI24 implements PlatformLocaleDelegate {
    public static final int $stable = 8;
    private LocaleList lastLocaleList;
    private android.os.LocaleList lastPlatformLocaleList;
    private final SynchronizedObject lock;

    public AndroidLocaleDelegateAPI24() {
        this.lock = new SynchronizedObject();
    }

    @Override // androidx.compose.ui.text.intl.PlatformLocaleDelegate
    public LocaleList getCurrent() {
        android.os.LocaleList r100 = android.os.LocaleList.getDefault();
        SynchronizedObject r101 = this.lock;
        monitor-enter(r101);
        LocaleList r102 = this.lastLocaleList;     // Catch: Throwable -> L16
        if (r102 != null) goto L7;
    L10:
        int r103 = r100.size();     // Catch: Throwable -> L16
        ArrayList r104 = new ArrayList(r103);     // Catch: Throwable -> L16
        int r105 = 0;
    L11:
        if (r105 >= r103) goto L13;
        r104.add(new Locale(r100.get(r105)));     // Catch: Throwable -> L16
        r105 = r105 + 1;     // Catch: Throwable -> L16
        goto L11
    L13:
        LocaleList r106 = new LocaleList(r104);     // Catch: Throwable -> L16
        this.lastPlatformLocaleList = r100;     // Catch: Throwable -> L16
        this.lastLocaleList = r106;     // Catch: Throwable -> L16
        monitor-exit(r101);
        return r106;
    L7:
        if (r100 != this.lastPlatformLocaleList) goto L10;
        monitor-exit(r101);
        return r102;
    L16:
        th = move-exception;
        throw th;
    }

    @Override // androidx.compose.ui.text.intl.PlatformLocaleDelegate
    public java.util.Locale parseLanguageTag(String r100) {
        java.util.Locale r101 = java.util.Locale.forLanguageTag(r100);
        if (Intrinsics.areEqual(r101.toLanguageTag(), "und") == false) goto L5;
        AndroidLocaleDelegate_androidKt.access$getTAG$p();
    L5:
        return r101;
    }
}
