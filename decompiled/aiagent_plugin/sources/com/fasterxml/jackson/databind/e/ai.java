package com.fasterxml.jackson.databind.e;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.e.ai;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: VisibilityChecker.java */
/* JADX INFO: loaded from: classes2.dex */
public interface ai<T extends ai<T>> {

    /* JADX INFO: compiled from: VisibilityChecker.java */
    public static class a implements ai<a>, Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected static final a f12603a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        protected static final a f12604b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        protected final JsonAutoDetect.Visibility f12605c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        protected final JsonAutoDetect.Visibility f12606d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        protected final JsonAutoDetect.Visibility f12607e;
        protected final JsonAutoDetect.Visibility f;
        protected final JsonAutoDetect.Visibility g;

        @Override // com.fasterxml.jackson.databind.e.ai
        public /* synthetic */ ai a(JsonAutoDetect.Value r1) {
            return b(r1);
        }

        @Override // com.fasterxml.jackson.databind.e.ai
        public /* synthetic */ ai a(JsonAutoDetect.Visibility r1) {
            return f(r1);
        }

        @Override // com.fasterxml.jackson.databind.e.ai
        public /* synthetic */ ai a(JsonAutoDetect r3) {
            return b((JsonAutoDetect) ZeusTransformUtils.wrapperContextForParams(r3, JsonAutoDetect.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.fasterxml.jackson.databind.e.ai
        public /* synthetic */ ai b(JsonAutoDetect.Visibility r1) {
            return g(r1);
        }

        @Override // com.fasterxml.jackson.databind.e.ai
        public /* synthetic */ ai c(JsonAutoDetect.Visibility r1) {
            return h(r1);
        }

        @Override // com.fasterxml.jackson.databind.e.ai
        public /* synthetic */ ai d(JsonAutoDetect.Visibility r1) {
            return i(r1);
        }

        @Override // com.fasterxml.jackson.databind.e.ai
        public /* synthetic */ ai e(JsonAutoDetect.Visibility r1) {
            return j(r1);
        }

        static {
            f12603a = new a(JsonAutoDetect.Visibility.PUBLIC_ONLY, JsonAutoDetect.Visibility.PUBLIC_ONLY, JsonAutoDetect.Visibility.ANY, JsonAutoDetect.Visibility.ANY, JsonAutoDetect.Visibility.PUBLIC_ONLY);
            f12604b = new a(JsonAutoDetect.Visibility.PUBLIC_ONLY, JsonAutoDetect.Visibility.PUBLIC_ONLY, JsonAutoDetect.Visibility.PUBLIC_ONLY, JsonAutoDetect.Visibility.PUBLIC_ONLY, JsonAutoDetect.Visibility.PUBLIC_ONLY);
        }

        public static a a() {
            return f12603a;
        }

        public static a b() {
            return f12604b;
        }

        public a(JsonAutoDetect.Visibility r1, JsonAutoDetect.Visibility r2, JsonAutoDetect.Visibility r3, JsonAutoDetect.Visibility r4, JsonAutoDetect.Visibility r5) {
            this.f12605c = r1;
            this.f12606d = r2;
            this.f12607e = r3;
            this.f = r4;
            this.g = r5;
        }

        public a a(JsonAutoDetect.Visibility r8, JsonAutoDetect.Visibility r9, JsonAutoDetect.Visibility r10, JsonAutoDetect.Visibility r11, JsonAutoDetect.Visibility r12) {
            if (r8 != this.f12605c) goto L14;
            if (r9 != this.f12606d) goto L14;
            if (r10 != this.f12607e) goto L14;
            if (r11 != this.f) goto L14;
            if (r12 != this.g) goto L14;
            return this;
        L14:
            return new a(r8, r9, r10, r11, r12);
        }

        public a b(JsonAutoDetect r9) {
            JsonAutoDetect r10 = (JsonAutoDetect) ZeusTransformUtils.wrapperContextForParams(r9, JsonAutoDetect.class, "com.obric.aiagent.plugin");
            if (r10 != null) goto L5;
            return this;
        L5:
            return a(a(this.f12605c, r10.getterVisibility()), a(this.f12606d, r10.isGetterVisibility()), a(this.f12607e, r10.setterVisibility()), a(this.f, r10.creatorVisibility()), a(this.g, r10.fieldVisibility()));
        }

        public a b(JsonAutoDetect.Value r9) {
            if (r9 != null) goto L4;
            return this;
        L4:
            return a(a(this.f12605c, r9.getGetterVisibility()), a(this.f12606d, r9.getIsGetterVisibility()), a(this.f12607e, r9.getSetterVisibility()), a(this.f, r9.getCreatorVisibility()), a(this.g, r9.getFieldVisibility()));
        }

        private JsonAutoDetect.Visibility a(JsonAutoDetect.Visibility r1, JsonAutoDetect.Visibility r2) {
            if (r2 != JsonAutoDetect.Visibility.DEFAULT) goto L5;
            return r1;
        L5:
            return r2;
        }

        public a f(JsonAutoDetect.Visibility r7) {
            if (r7 != JsonAutoDetect.Visibility.DEFAULT) goto L5;
            r7 = f12603a.f12605c;
        L5:
            JsonAutoDetect.Visibility r1 = r7;
            if (this.f12605c != r1) goto L9;
            return this;
        L9:
            return new a(r1, this.f12606d, this.f12607e, this.f, this.g);
        }

        public a g(JsonAutoDetect.Visibility r7) {
            if (r7 != JsonAutoDetect.Visibility.DEFAULT) goto L5;
            r7 = f12603a.f12606d;
        L5:
            JsonAutoDetect.Visibility r2 = r7;
            if (this.f12606d != r2) goto L9;
            return this;
        L9:
            return new a(this.f12605c, r2, this.f12607e, this.f, this.g);
        }

        public a h(JsonAutoDetect.Visibility r7) {
            if (r7 != JsonAutoDetect.Visibility.DEFAULT) goto L5;
            r7 = f12603a.f12607e;
        L5:
            JsonAutoDetect.Visibility r3 = r7;
            if (this.f12607e != r3) goto L9;
            return this;
        L9:
            return new a(this.f12605c, this.f12606d, r3, this.f, this.g);
        }

        public a i(JsonAutoDetect.Visibility r7) {
            if (r7 != JsonAutoDetect.Visibility.DEFAULT) goto L5;
            r7 = f12603a.f;
        L5:
            JsonAutoDetect.Visibility r4 = r7;
            if (this.f != r4) goto L9;
            return this;
        L9:
            return new a(this.f12605c, this.f12606d, this.f12607e, r4, this.g);
        }

        public a j(JsonAutoDetect.Visibility r7) {
            if (r7 != JsonAutoDetect.Visibility.DEFAULT) goto L5;
            r7 = f12603a.g;
        L5:
            JsonAutoDetect.Visibility r5 = r7;
            if (this.g != r5) goto L9;
            return this;
        L9:
            return new a(this.f12605c, this.f12606d, this.f12607e, this.f, r5);
        }

        public boolean a(Member r3) {
            Member r4 = (Member) ZeusTransformUtils.wrapperContextForParams(r3, Member.class, "com.obric.aiagent.plugin");
            return this.f.isVisible(r4);
        }

        @Override // com.fasterxml.jackson.databind.e.ai
        public boolean a(j r1) {
            return a(r1.g());
        }

        public boolean a(Field r1) {
            return this.g.isVisible(r1);
        }

        @Override // com.fasterxml.jackson.databind.e.ai
        public boolean a(h r1) {
            return a(r1.d());
        }

        public boolean a(Method r1) {
            return this.f12605c.isVisible(r1);
        }

        @Override // com.fasterxml.jackson.databind.e.ai
        public boolean a(k r1) {
            return a(r1.d());
        }

        public boolean b(Method r1) {
            return this.f12606d.isVisible(r1);
        }

        @Override // com.fasterxml.jackson.databind.e.ai
        public boolean b(k r1) {
            return b(r1.d());
        }

        public boolean c(Method r1) {
            return this.f12607e.isVisible(r1);
        }

        @Override // com.fasterxml.jackson.databind.e.ai
        public boolean c(k r1) {
            return c(r1.d());
        }

        public String toString() {
            return String.format("[Visibility: getter=%s,isGetter=%s,setter=%s,creator=%s,field=%s]", new Object[]{this.f12605c, this.f12606d, this.f12607e, this.f, this.g});
        }
    }

    T a(JsonAutoDetect.Value r1);

    T a(JsonAutoDetect.Visibility r1);

    T a(JsonAutoDetect r1);

    boolean a(h r1);

    boolean a(j r1);

    boolean a(k r1);

    T b(JsonAutoDetect.Visibility r1);

    boolean b(k r1);

    T c(JsonAutoDetect.Visibility r1);

    boolean c(k r1);

    T d(JsonAutoDetect.Visibility r1);

    T e(JsonAutoDetect.Visibility r1);
}
