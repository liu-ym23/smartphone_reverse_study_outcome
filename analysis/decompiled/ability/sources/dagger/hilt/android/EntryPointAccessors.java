package dagger.hilt.android;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import dagger.hilt.EntryPoints;
import dagger.hilt.android.internal.Contexts;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\u0004\u001a\u0002H\u0005\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00050\tH\u0007¢\u0006\u0002\u0010\nJ\u001e\u0010\u0004\u001a\u0002H\u0005\"\u0006\b\u0000\u0010\u0005\u0018\u00012\u0006\u0010\u0006\u001a\u00020\u0007H\u0086\b¢\u0006\u0002\u0010\u000bJ)\u0010\f\u001a\u0002H\u0005\"\u0004\b\u0000\u0010\u00052\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00050\tH\u0007¢\u0006\u0002\u0010\u000fJ\u001e\u0010\f\u001a\u0002H\u0005\"\u0006\b\u0000\u0010\u0005\u0018\u00012\u0006\u0010\r\u001a\u00020\u000eH\u0086\b¢\u0006\u0002\u0010\u0010J)\u0010\u0011\u001a\u0002H\u0005\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0012\u001a\u00020\u00132\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00050\tH\u0007¢\u0006\u0002\u0010\u0014J\u001e\u0010\u0011\u001a\u0002H\u0005\"\u0006\b\u0000\u0010\u0005\u0018\u00012\u0006\u0010\u0012\u001a\u00020\u0013H\u0086\b¢\u0006\u0002\u0010\u0015J)\u0010\u0016\u001a\u0002H\u0005\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0017\u001a\u00020\u00182\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00050\tH\u0007¢\u0006\u0002\u0010\u0019J\u001e\u0010\u0016\u001a\u0002H\u0005\"\u0006\b\u0000\u0010\u0005\u0018\u00012\u0006\u0010\u0017\u001a\u00020\u0018H\u0086\b¢\u0006\u0002\u0010\u001a¨\u0006\u001b"}, d2 = {"Ldagger/hilt/android/EntryPointAccessors;", "", AppAgent.CONSTRUCT, "()V", "fromApplication", ExifInterface.GPS_DIRECTION_TRUE, "context", "Landroid/content/Context;", "entryPoint", "Ljava/lang/Class;", "(Landroid/content/Context;Ljava/lang/Class;)Ljava/lang/Object;", "(Landroid/content/Context;)Ljava/lang/Object;", "fromActivity", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;Ljava/lang/Class;)Ljava/lang/Object;", "(Landroid/app/Activity;)Ljava/lang/Object;", "fromFragment", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;Ljava/lang/Class;)Ljava/lang/Object;", "(Landroidx/fragment/app/Fragment;)Ljava/lang/Object;", "fromView", "view", "Landroid/view/View;", "(Landroid/view/View;Ljava/lang/Class;)Ljava/lang/Object;", "(Landroid/view/View;)Ljava/lang/Object;", "hilt-android_main_java_dagger_hilt_android-entry_point_accessors_internal_kt"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class EntryPointAccessors {
    public static final EntryPointAccessors INSTANCE = new EntryPointAccessors();

    private EntryPointAccessors() {
    }

    public static final <T> T fromActivity(Activity activity, Class<T> entryPoint) {
        k.f(activity, "activity");
        k.f(entryPoint, "entryPoint");
        return (T) EntryPoints.get(activity, entryPoint);
    }

    public static final <T> T fromApplication(Context context, Class<T> entryPoint) {
        k.f(context, "context");
        k.f(entryPoint, "entryPoint");
        return (T) EntryPoints.get(Contexts.getApplication(context.getApplicationContext()), entryPoint);
    }

    public static final <T> T fromFragment(Fragment fragment, Class<T> entryPoint) {
        k.f(fragment, "fragment");
        k.f(entryPoint, "entryPoint");
        return (T) EntryPoints.get(fragment, entryPoint);
    }

    public static final <T> T fromView(View view, Class<T> entryPoint) {
        k.f(view, "view");
        k.f(entryPoint, "entryPoint");
        return (T) EntryPoints.get(view, entryPoint);
    }

    public final <T> T fromActivity(Activity activity) {
        k.f(activity, "activity");
        k.m();
        throw null;
    }

    public final <T> T fromApplication(Context context) {
        k.f(context, "context");
        k.m();
        throw null;
    }

    public final <T> T fromFragment(Fragment fragment) {
        k.f(fragment, "fragment");
        k.m();
        throw null;
    }

    public final <T> T fromView(View view) {
        k.f(view, "view");
        k.m();
        throw null;
    }
}
