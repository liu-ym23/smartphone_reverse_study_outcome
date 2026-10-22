package androidx.fragment.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import androidx.core.app.ActivityCompat;
import com.volcengine.zeus.activity.GeneratePluginActivity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: compiled from: FragmentHostCallback.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class e<E> extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Activity f1801a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final FragmentManager f1802b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Context f1803c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Handler f1804d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f1805e;

    @Override // androidx.fragment.app.c
    public View a(int r1) {
        return null;
    }

    @Deprecated
    public void a(Fragment r1, String[] r2, int r3) {
    }

    public void a(String r1, FileDescriptor r2, PrintWriter r3, String[] r4) {
    }

    @Override // androidx.fragment.app.c
    public boolean a() {
        return true;
    }

    public boolean a(Fragment r1) {
        return true;
    }

    public boolean a(String r1) {
        return false;
    }

    public void d() {
    }

    public abstract E e();

    e(FragmentActivity r3) {
        GeneratePluginActivity r4 = (FragmentActivity) ZeusTransformUtils.wrapperContextForParams(r3, FragmentActivity.class, "com.obric.aiagent.plugin");
        this(r4, r4, new Handler(), 0);
    }

    e(Activity r3, Context r4, Handler r5, int r6) {
        Activity r7 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.aiagent.plugin");
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        this.f1802b = new g();
        this.f1801a = ZeusTransformUtils.wrapperContext2Activity(r7, "com.obric.aiagent.plugin");
        this.f1803c = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(androidx.core.util.g.a(r8, "context == null"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        this.f1804d = (Handler) ZeusTransformUtils.preCheckCast(androidx.core.util.g.a(r5, "handler == null"), Handler.class, "com.obric.aiagent.plugin");
        this.f1805e = r6;
    }

    public LayoutInflater b() {
        return LayoutInflater.from(this.f1803c);
    }

    public void a(Fragment r1, Intent r2, int r3, Bundle r4) {
        if (r3 != (-1)) goto L7;
        androidx.core.content.a.startActivity(this.f1803c, r2, r4);
        return;
    L7:
        throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
    }

    @Deprecated
    public void a(Fragment r10, IntentSender r11, int r12, Intent r13, int r14, int r15, int r16, Bundle r17) {
        if (r12 != (-1)) goto L7;
        ActivityCompat.a(this.f1801a, r11, r12, r13, r14, r15, r16, r17);
        return;
    L7:
        throw new IllegalStateException("Starting intent sender with a requestCode requires a FragmentActivity host");
    }

    Activity getActivity() {
        return this.f1801a;
    }

    Context getContext() {
        return this.f1803c;
    }

    Handler f() {
        return this.f1804d;
    }
}
