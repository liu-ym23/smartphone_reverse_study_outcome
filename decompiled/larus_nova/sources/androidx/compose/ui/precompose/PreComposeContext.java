package androidx.compose.ui.precompose;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.view.ContextThemeWrapper;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\bJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0003J\u0012\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0003H\u0016R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Landroidx/compose/ui/precompose/PreComposeContext;", "Landroid/view/ContextThemeWrapper;", "base", "Landroid/content/Context;", "themeResId", "", "<init>", "(Landroid/content/Context;I)V", "(Landroid/content/Context;)V", PerfLog.PARAM_KEY_CONTEXT_ID, "Ljava/lang/ref/WeakReference;", "getContext", "()Ljava/lang/ref/WeakReference;", "setContext", "(Ljava/lang/ref/WeakReference;)V", "replaceContext", "", "startActivity", "intent", "Landroid/content/Intent;", "getResources", "Landroid/content/res/Resources;", "getAssets", "Landroid/content/res/AssetManager;", "getBaseContext", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PreComposeContext extends ContextThemeWrapper {
    public static final int $stable = 8;
    private WeakReference<Context> context;

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        WeakReference<Context> r100 = this.context;
        if (r100 == null) goto L11;
        Context r101 = r100.get();
        if (r101 == null) goto L11;
        Resources r102 = r101.getResources();
        if (r102 == null) goto L11;
        AssetManager r103 = r102.getAssets();
        if (r103 == null) goto L11;
        return r103;
    L11:
        return super.getAssets();
    }

    @Override // android.content.ContextWrapper
    public Context getBaseContext() {
        WeakReference<Context> r100 = this.context;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.get();
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        WeakReference<Context> r100 = this.context;
        if (r100 == null) goto L9;
        Context r101 = r100.get();
        if (r101 == null) goto L9;
        Resources r102 = r101.getResources();
        if (r102 == null) goto L9;
        return r102;
    L9:
        return super.getResources();
    }

    public final WeakReference<Context> getContext() {
        return this.context;
    }

    public PreComposeContext(Context r100) {
        super(r100, 0);
        this.context = new WeakReference(r100);
    }

    public final void replaceContext(Context r100) {
        this.context = new WeakReference(r100);
    }

    public final void setContext(WeakReference<Context> r100) {
        this.context = r100;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent r100) {
        WeakReference<Context> r101 = this.context;
        Context r102 = null;
        if (r101 == null) goto L5;
        Context r103 = r101.get();
    L7:
        if ((r103 instanceof Activity) == false) goto L14;
        WeakReference<Context> r104 = this.context;
        if (r104 == null) goto L11;
        r102 = r104.get();
    L11:
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type android.app.Activity");
        ((Activity) r102).startActivity(r100);
        return;
    L14:
        throw new IllegalStateException("Context is null or not an Activity".toString());
    L5:
        r103 = null;
        goto L7
    }

    public PreComposeContext(Context r100, int r101) {
        super(r100.getApplicationContext(), r101);
        this.context = new WeakReference(r100);
    }
}
