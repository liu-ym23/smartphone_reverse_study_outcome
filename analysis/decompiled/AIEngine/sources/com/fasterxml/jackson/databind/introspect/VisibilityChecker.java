package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import java.io.Serializable;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public interface VisibilityChecker<T extends VisibilityChecker<T>> {

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class Std implements VisibilityChecker<Std>, Serializable {
        public static final Std h;

        /* renamed from: a, reason: collision with root package name */
        public final JsonAutoDetect.Visibility f4169a;

        /* renamed from: b, reason: collision with root package name */
        public final JsonAutoDetect.Visibility f4170b;

        /* renamed from: c, reason: collision with root package name */
        public final JsonAutoDetect.Visibility f4171c;

        /* renamed from: d, reason: collision with root package name */
        public final JsonAutoDetect.Visibility f4172d;

        /* renamed from: e, reason: collision with root package name */
        public final JsonAutoDetect.Visibility f4173e;

        static {
            JsonAutoDetect.Visibility visibility = JsonAutoDetect.Visibility.f3425b;
            JsonAutoDetect.Visibility visibility2 = JsonAutoDetect.Visibility.f3424a;
            h = new Std(visibility, visibility, visibility2, visibility2, visibility);
        }

        public Std(JsonAutoDetect.Visibility visibility, JsonAutoDetect.Visibility visibility2, JsonAutoDetect.Visibility visibility3, JsonAutoDetect.Visibility visibility4, JsonAutoDetect.Visibility visibility5) {
            this.f4169a = visibility;
            this.f4170b = visibility2;
            this.f4171c = visibility3;
            this.f4172d = visibility4;
            this.f4173e = visibility5;
        }

        public final String toString() {
            return "[Visibility: getter=" + this.f4169a + ",isGetter=" + this.f4170b + ",setter=" + this.f4171c + ",creator=" + this.f4172d + ",field=" + this.f4173e + "]";
        }
    }
}
