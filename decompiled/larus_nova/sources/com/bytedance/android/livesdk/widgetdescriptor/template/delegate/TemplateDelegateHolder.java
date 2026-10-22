package com.bytedance.android.livesdk.widgetdescriptor.template.delegate;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.android.live.core.tetris.template.delegate.BaseTemplateDelegate;
import h70.b;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class TemplateDelegateHolder implements b80.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f162487a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ViewModelProvider f162488b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f162489c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f162490d;

    public static final class a implements com.bytedance.android.live.core.tetris.layer.core.data.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TemplateDelegateHolder f162491a;

        public a(TemplateDelegateHolder r100) {
            this.f162491a = r100;
        }

        @Override // com.bytedance.android.live.core.tetris.layer.core.data.b
        public final <T extends ViewModel> T getViewModel(Class<T> r100) {
            Intrinsics.checkNotNullParameter(r100, "modelClass");
            ViewModelProvider r101 = this.f162491a.f162488b;
            if (r101 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException("viewModelProvider");
        L6:
            return (T) r101.get(r100);
        }
    }

    @Override // b80.a
    public final List<BaseTemplateDelegate<? extends b>> a() {
        return CollectionsKt.toList(((Map) this.f162490d.getValue()).values());
    }

    public TemplateDelegateHolder() {
        this.f162489c = new a(this);
        this.f162490d = LazyKt.lazy(new TemplateDelegateHolder$delegateMap$2(this));
    }
}
