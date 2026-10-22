package com.bytedance.android.live.revenue.common;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.facebook.keyframes.model.KFAnimation;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KClass;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public abstract class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JsonObject f90911a;

    public static final class a<T> implements ReadWriteProperty<p, T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f90912a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final KClass<?> f90913b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final T f90914c;

        public final KClass<?> getType() {
            return this.f90913b;
        }

        public a(String r100, KClass r101) {
            Intrinsics.checkNotNullParameter(r100, "key");
            Intrinsics.checkNotNullParameter(r101, "type");
            this.f90912a = r100;
            this.f90913b = r101;
            this.f90914c = null;
        }

        public final T a(p r100, KProperty<?> r101) {
            Intrinsics.checkNotNullParameter(r100, "thisRef");
            Intrinsics.checkNotNullParameter(r101, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
            JsonObject r102 = r100.f90911a;
            if (r102.has(this.f90912a) == false) goto L7;
            JsonElement r103 = r102.get(this.f90912a);
            Intrinsics.checkNotNull(r103);
            KClass<?> r104 = this.f90913b;
            return (T) GsonProtectorUtils.fromJson(l97.a.f508113a, r103, JvmClassMappingKt.getJavaClass(r104));
        L7:
            return this.f90914c;
        }

        @Override // kotlin.properties.ReadWriteProperty, kotlin.properties.ReadOnlyProperty
        public final /* bridge */ /* synthetic */ Object getValue(Object r100, KProperty r101) {
            return a((p) r100, r101);
        }

        public final void b(p r100, KProperty<?> r101, T r102) {
            Intrinsics.checkNotNullParameter(r100, "thisRef");
            Intrinsics.checkNotNullParameter(r101, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
            r100.f90911a.add(this.f90912a, GsonProtectorUtils.toJsonTree(l97.a.f508113a, r102));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.properties.ReadWriteProperty
        public final /* bridge */ /* synthetic */ void setValue(p r100, KProperty r101, Object r102) {
            b(r100, r101, r102);
        }
    }

    public p(JsonObject r100) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        this.f90911a = r100;
    }
}
