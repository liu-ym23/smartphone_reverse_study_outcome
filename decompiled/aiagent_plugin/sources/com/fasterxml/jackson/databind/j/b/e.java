package com.fasterxml.jackson.databind.j.b;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: BooleanSerializer.java */
/* JADX INFO: loaded from: classes2.dex */
@JacksonStdImpl
public final class e extends ai<Object> implements com.fasterxml.jackson.databind.j.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final boolean f12898a;

    /* JADX INFO: compiled from: BooleanSerializer.java */
    static final class a extends ai<Object> implements com.fasterxml.jackson.databind.j.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected final boolean f12899a;

        public a(boolean r3) {
            if (r3 == false) goto L4;
            Class<Boolean> r0 = Boolean.TYPE;
        L5:
            super(r0, false);
            this.f12899a = r3;
            return;
        L4:
            r0 = Boolean.class;
            goto L5
        }

        @Override // com.fasterxml.jackson.databind.j.b.aj, com.fasterxml.jackson.databind.p
        public void a(Object r1, com.fasterxml.jackson.a.h r2, com.fasterxml.jackson.databind.ac r3) {
            r2.d(!Boolean.FALSE.equals(r1) ? 1 : 0);
        }

        @Override // com.fasterxml.jackson.databind.j.b.ai, com.fasterxml.jackson.databind.p
        public final void a(Object r1, com.fasterxml.jackson.a.h r2, com.fasterxml.jackson.databind.ac r3, com.fasterxml.jackson.databind.h.h r4) {
            r2.a(Boolean.TRUE.equals(r1));
        }

        @Override // com.fasterxml.jackson.databind.j.j
        public com.fasterxml.jackson.databind.p<?> a(com.fasterxml.jackson.databind.ac r3, com.fasterxml.jackson.databind.d r4) {
            JsonFormat.Value r5 = a(r3, (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r4, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin"), Boolean.class);
            if (r5 != null) goto L5;
        L8:
            return this;
        L5:
            if (r5.getShape().isNumeric() == true) goto L8;
            return new e(this.f12899a);
        }
    }

    public e(boolean r3) {
        if (r3 == false) goto L4;
        Class<Boolean> r0 = Boolean.TYPE;
    L5:
        super(r0, false);
        this.f12898a = r3;
        return;
    L4:
        r0 = Boolean.class;
        goto L5
    }

    @Override // com.fasterxml.jackson.databind.j.j
    public com.fasterxml.jackson.databind.p<?> a(com.fasterxml.jackson.databind.ac r3, com.fasterxml.jackson.databind.d r4) {
        JsonFormat.Value r5 = a(r3, (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r4, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin"), a());
        if (r5 == null) goto L12;
        JsonFormat.Shape r6 = r5.getShape();
        if (r6.isNumeric() == false) goto L9;
        return new a(this.f12898a);
    L9:
        if (r6 != JsonFormat.Shape.STRING) goto L12;
        return new an(this.r);
    L12:
        return this;
    }

    @Override // com.fasterxml.jackson.databind.j.b.aj, com.fasterxml.jackson.databind.p
    public void a(Object r1, com.fasterxml.jackson.a.h r2, com.fasterxml.jackson.databind.ac r3) {
        r2.a(Boolean.TRUE.equals(r1));
    }

    @Override // com.fasterxml.jackson.databind.j.b.ai, com.fasterxml.jackson.databind.p
    public final void a(Object r1, com.fasterxml.jackson.a.h r2, com.fasterxml.jackson.databind.ac r3, com.fasterxml.jackson.databind.h.h r4) {
        r2.a(Boolean.TRUE.equals(r1));
    }
}
