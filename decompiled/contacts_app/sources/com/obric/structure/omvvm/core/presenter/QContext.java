package com.obric.structure.omvvm.core.presenter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.activity.result.ActivityResultCaller;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import com.obric.structure.omvvm.core.ui.QUIManager;
import com.obric.structure.omvvm.core.util.ViewModelStoreOwnerDelegate;
import com.obric.structure.omvvm.core.viewmodel.QViewModel;
import com.obric.structure.omvvm.core.viewmodel.QViewModelOwner;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: QContext.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0015\u0010\u0011\u001a\u0002H\u0012\"\b\b\u0000\u0010\u0012*\u00020\u0013¢\u0006\u0002\u0010\u0014J\u0017\u0010\u0015\u001a\u0004\u0018\u0001H\u0012\"\b\b\u0000\u0010\u0012*\u00020\u0016¢\u0006\u0002\u0010\u0017J\u0006\u0010\u0018\u001a\u00020\u0019J-\u0010\u001a\u001a\u0004\u0018\u0001H\u0012\"\b\b\u0000\u0010\u0012*\u00020\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u00120\u001d2\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u001eJ\u0006\u0010\u001f\u001a\u00020\u0019J\b\u0010 \u001a\u0004\u0018\u00010\fJ\u0006\u0010!\u001a\u00020\"J#\u0010#\u001a\u0002H\u0012\"\b\b\u0000\u0010\u0012*\u00020\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u00120\u001d¢\u0006\u0002\u0010$J#\u0010%\u001a\u0002H\u0012\"\b\b\u0000\u0010\u0012*\u00020\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u00120\u001d¢\u0006\u0002\u0010$J+\u0010%\u001a\u0002H\u0012\"\b\b\u0000\u0010\u0012*\u00020\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u00120\u001d2\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u001eJ3\u0010%\u001a\u0002H\u0012\"\b\b\u0000\u0010\u0012*\u00020\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u00120\u001d2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010&\u001a\u00020'¢\u0006\u0002\u0010(J%\u0010)\u001a\u0004\u0018\u0001H\u0012\"\b\b\u0000\u0010\u0012*\u00020\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u00120\u001d¢\u0006\u0002\u0010$J-\u0010)\u001a\u0004\u0018\u0001H\u0012\"\b\b\u0000\u0010\u0012*\u00020\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u00120\u001d2\u0006\u0010&\u001a\u00020'¢\u0006\u0002\u0010*R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/obric/structure/omvvm/core/presenter/QContext;", "", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "fragment", "Landroidx/fragment/app/Fragment;", "getFragment", "()Landroidx/fragment/app/Fragment;", "setFragment", "(Landroidx/fragment/app/Fragment;)V", "uiManager", "Lcom/obric/structure/omvvm/core/ui/QUIManager;", "getUiManager", "()Lcom/obric/structure/omvvm/core/ui/QUIManager;", "setUiManager", "(Lcom/obric/structure/omvvm/core/ui/QUIManager;)V", "activity", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/fragment/app/FragmentActivity;", "()Landroidx/fragment/app/FragmentActivity;", "activityNullable", "Landroid/app/Activity;", "()Landroid/app/Activity;", "appContext", "Landroid/content/Context;", "asyncVmOfFragment", "Lcom/obric/structure/omvvm/core/viewmodel/QViewModel;", "clazz", "Ljava/lang/Class;", "(Ljava/lang/Class;Landroidx/fragment/app/Fragment;)Lcom/obric/structure/omvvm/core/viewmodel/QViewModel;", "context", "getUiManagerSafely", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "vmOfActivity", "(Ljava/lang/Class;)Lcom/obric/structure/omvvm/core/viewmodel/QViewModel;", "vmOfFragment", "factory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "(Ljava/lang/Class;Landroidx/fragment/app/Fragment;Landroidx/lifecycle/ViewModelProvider$Factory;)Lcom/obric/structure/omvvm/core/viewmodel/QViewModel;", "vmOfManager", "(Ljava/lang/Class;Landroidx/lifecycle/ViewModelProvider$Factory;)Lcom/obric/structure/omvvm/core/viewmodel/QViewModel;", "omvvm-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class QContext {
    private Fragment fragment;
    public QUIManager uiManager;
    private final View view;

    public QContext(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        this.view = r2;
    }

    public final Fragment getFragment() {
        return this.fragment;
    }

    public final void setFragment(Fragment r1) {
        this.fragment = r1;
    }

    public final QUIManager getUiManager() {
        QUIManager r0 = this.uiManager;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("uiManager");
        return null;
    }

    public final void setUiManager(QUIManager r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.uiManager = r2;
    }

    public final QUIManager getUiManagerSafely() {
        if (this.uiManager != null) goto L5;
        return null;
    L5:
        return getUiManager();
    }

    public final Context context() {
        Context r1 = this.view.getContext();
        Intrinsics.checkNotNullExpressionValue(r1, "view.context");
        return r1;
    }

    public final Context appContext() {
        Context r1 = this.view.getContext().getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(r1, "view.context.applicationContext");
        return r1;
    }

    public final <T extends FragmentActivity> T activity() {
        Context r1 = this.view.getContext();
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type T of com.obric.structure.omvvm.core.presenter.QContext.activity");
        return (T) r1;
    }

    public final <T extends Activity> T activityNullable() {
        Context r1 = this.view.getContext();
        if ((r1 instanceof Activity) == true) goto L7;
        return null;
    L7:
        return (T) r1;
    }

    public final LifecycleOwner lifecycleOwner() {
        Fragment r0 = this.fragment;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return activity();
    }

    public final <T extends QViewModel> T vmOfActivity(Class<T> r3) {
        Intrinsics.checkNotNullParameter(r3, "clazz");
        Object r0 = this.view.getContext();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.obric.structure.omvvm.core.viewmodel.QViewModelOwner");
        return (T) new ViewModelProvider(activity(), ((QViewModelOwner) r0).getFactory()).get(r3);
    }

    public final <T extends QViewModel> T vmOfFragment(Class<T> r3) {
        Intrinsics.checkNotNullParameter(r3, "clazz");
        ActivityResultCaller r0 = this.fragment;
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.obric.structure.omvvm.core.viewmodel.QViewModelOwner");
        Fragment r2 = this.fragment;
        Intrinsics.checkNotNull(r2);
        return (T) new ViewModelProvider(r2, ((QViewModelOwner) r0).getFactory()).get(r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T extends QViewModel> T vmOfFragment(Class<T> r2, Fragment r3) {
        Intrinsics.checkNotNullParameter(r2, "clazz");
        Intrinsics.checkNotNullParameter(r3, "fragment");
        QViewModelOwner r1 = (QViewModelOwner) r3;
        return (T) new ViewModelProvider(r3, r1.getFactory()).get(r2);
    }

    public final <T extends QViewModel> T vmOfFragment(Class<T> r1, Fragment r2, ViewModelProvider.Factory r3) {
        Intrinsics.checkNotNullParameter(r1, "clazz");
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "factory");
        return (T) new ViewModelProvider(r2, r3).get(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T extends QViewModel> T asyncVmOfFragment(Class<T> r2, Fragment r3) {
        Intrinsics.checkNotNullParameter(r2, "clazz");
        Intrinsics.checkNotNullParameter(r3, "fragment");
        QViewModelOwner r1 = (QViewModelOwner) r3;     // Catch: IllegalStateException -> L5
        return (T) new ViewModelProvider(r3, r1.getFactory()).get(r2);
    L5:
        return null;
    }

    public final <T extends QViewModel> T vmOfManager(Class<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "clazz");
        return (T) new ViewModelProvider(getUiManager().getVmStoreOwner$omvvm_core_release()).get(r2);
    L5:
        return null;
    }

    public final <T extends QViewModel> T vmOfManager(Class<T> r3, ViewModelProvider.Factory r4) {
        Intrinsics.checkNotNullParameter(r3, "clazz");
        Intrinsics.checkNotNullParameter(r4, "factory");
        QUIManager r2 = getUiManager();     // Catch: Throwable -> L11
        if (r2 == null) goto L14;
        ViewModelStoreOwnerDelegate r5 = r2.getVmStoreOwner$omvvm_core_release();     // Catch: Throwable -> L11
        if (r5 == null) goto L15;
        return (T) new ViewModelProvider(r5, r4).get(r3);
    L15:
        return null;
    L14:
        return null;
    L16:
        return null;
    }
}
