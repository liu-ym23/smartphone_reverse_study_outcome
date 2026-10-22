package com.bytedance.android.shopping.anchorv3.activities.quick.base.event;

import androidx.collection.ArrayMap;
import c53.d;
import com.bytedance.android.ec.sdk.helper.g;
import io.reactivex.Completable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class DefaultEventAction implements com.bytedance.android.shopping.anchorv3.activities.quick.base.event.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayMap f164396a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final xi.a f164397b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f164398c;

    public static final class a implements Action {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DefaultEventAction f164399a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f164400b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Map f164401c;

        public a(DefaultEventAction r100, String r101, Map r102) {
            this.f164399a = r100;
            this.f164400b = r101;
            this.f164401c = r102;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            DefaultEventAction r100 = this.f164399a;
            String r101 = this.f164400b;
            Map r102 = this.f164401c;
            r100.f164397b.logV3(r101, new JSONObject(r102));
        }
    }

    public static final class b implements Action {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f164402a = null;

        static {
            f164402a = new b();
        }

        public b() {
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f164403a = null;

        static {
            f164403a = new c();
        }

        public c() {
        }

        @Override // io.reactivex.functions.Consumer
        public final /* bridge */ /* synthetic */ void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
        }
    }

    public DefaultEventAction(d r100) {
        int r101 = com.bytedance.android.shopping.anchorv3.activities.quick.base.event.c.f164405a;
        g r102 = g.f48122a;
        Intrinsics.checkNotNullParameter(r102, "hostLogService");
        Intrinsics.checkNotNullParameter(r100, "disposableContext");
        this.f164397b = r102;
        this.f164398c = r100;
        ArrayMap r103 = new ArrayMap();
        this.f164396a = r103;
        int r104 = com.bytedance.android.shopping.anchorv3.activities.quick.base.event.a.f164404a;
        String r105 = com.bytedance.android.ec.core.event.a.VALUE_DATA_TYPE;
        Intrinsics.checkNotNullParameter(com.bytedance.android.ec.core.event.a.VALUE_DATA_TYPE, "param");
        String r106 = "";
        if (Intrinsics.areEqual(com.bytedance.android.ec.core.event.a.VALUE_DATA_TYPE, "null") == false) goto L5;
        r105 = "";
    L5:
        r103.put("data_type", r105);
        Intrinsics.checkNotNullParameter(com.bytedance.android.ec.core.event.a.VALUE_TEMAI, "param");
        if (Intrinsics.areEqual(com.bytedance.android.ec.core.event.a.VALUE_TEMAI, "null") == true) goto L9;
        r106 = com.bytedance.android.ec.core.event.a.VALUE_TEMAI;
    L9:
        r103.put(com.bytedance.android.ec.core.event.a.KEY_EVENT_ORIGIN_FEATURE, r106);
    }

    @Override // com.bytedance.android.shopping.anchorv3.activities.quick.base.event.b
    public final void appendEventParams(Pair<String, String>... r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        MapsKt.putAll(this.f164396a, SequencesKt.filter(ArraysKt.asSequence(r100), AnonymousClass1.INSTANCE));
    }

    @Override // com.bytedance.android.shopping.anchorv3.activities.quick.base.event.b
    public final void initEventContext(Pair<String, String>... r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        MapsKt.putAll(this.f164396a, SequencesKt.filter(ArraysKt.asSequence(r100), C102671.INSTANCE));
    }

    @Override // com.bytedance.android.shopping.anchorv3.activities.quick.base.event.b
    public final void doEventAction(String r100, Pair<String, String>... r101) {
        Intrinsics.checkNotNullParameter(r100, "actionName");
        Intrinsics.checkNotNullParameter(r101, "params");
        Disposable r102 = bg4.b.a(Completable.fromAction(new a(this, r100, MapsKt.plus(this.f164396a, r101)))).subscribe(b.f164402a, c.f164403a);
        d r103 = this.f164398c;
        Intrinsics.checkNotNullParameter(r102, "$this$ignore");
        Intrinsics.checkNotNullParameter(r103, "disposableContext");
        r103.ignore(r102);
    }
}
