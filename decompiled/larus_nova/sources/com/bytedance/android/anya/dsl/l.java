package com.bytedance.android.anya.dsl;

import com.bytedance.android.anya.AnyaDSL;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.l0;
import com.bytedance.android.anya.p;
import com.bytedance.android.anya.r;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;

/* JADX INFO: loaded from: classes43.dex */
@AnyaDSL
public final class l<VIEW_STATE extends MVIState<?>, STATE extends r, ACTION extends p> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashMap<Class<? extends STATE>, Map<Class<? extends ACTION>, Function4<l0<VIEW_STATE>, VIEW_STATE, STATE, ACTION, Unit>>> f41603a;

    @AnyaDSL
    public final class a<S extends STATE> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final LinkedHashMap<Class<? extends ACTION>, Function4<l0<VIEW_STATE>, VIEW_STATE, STATE, ACTION, Unit>> f41604a;

        public a() {
            this.f41604a = new LinkedHashMap();
        }
    }

    public l() {
        this.f41603a = new LinkedHashMap();
    }
}
