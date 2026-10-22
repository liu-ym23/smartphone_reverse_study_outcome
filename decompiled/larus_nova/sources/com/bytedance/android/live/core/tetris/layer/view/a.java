package com.bytedance.android.live.core.tetris.layer.view;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.android.live.core.tetris.layer.core.delegate.c;
import com.bytedance.android.live.core.tetris.layer.core.element.ElementBuilderMap;
import com.bytedance.android.live.core.tetris.layer.core.event.LayerEventDispatcher;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c<h70.b> f65866a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ElementBuilderMap f65867b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public h70.b f65868c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LayerEventDispatcher f65869d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public r70.b<h70.b> f65870e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public r70.a<h70.b> f65871f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public r70.a<h70.b> f65872g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map<Class<s70.b<h70.b>>, s70.a<s70.b<h70.b>, h70.b>> f65873h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public b80.a f65874i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ViewModelProvider f65875j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final C1086a f65876k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final p70.b f65877l;

    /* JADX INFO: renamed from: com.bytedance.android.live.core.tetris.layer.view.a$a, reason: collision with other inner class name */
    public static final class C1086a implements com.bytedance.android.live.core.tetris.layer.core.data.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f65878a;

        public C1086a(a r100) {
            this.f65878a = r100;
        }

        @Override // com.bytedance.android.live.core.tetris.layer.core.data.b
        public final <T extends ViewModel> T getViewModel(Class<T> r100) {
            Intrinsics.checkNotNullParameter(r100, "modelClass");
            ViewModelProvider r101 = this.f65878a.f65875j;
            if (r101 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException("viewModelProvider");
        L6:
            return (T) r101.get(r100);
        }
    }

    public final h70.b a() {
        h70.b r100 = this.f65868c;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("layerContext");
    L5:
        return r100;
    }

    public a() {
        this.f65873h = new LinkedHashMap();
        this.f65876k = new C1086a(this);
        this.f65877l = new p70.b();
    }
}
