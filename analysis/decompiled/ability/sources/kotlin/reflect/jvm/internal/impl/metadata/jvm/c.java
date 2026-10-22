package kotlin.reflect.jvm.internal.impl.metadata.jvm;

import H8.AbstractC0241b;
import H8.j;
import H8.s;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$StringTableTypes;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException;

/* loaded from: classes4.dex */
public final class c extends j implements s {
    public int b;
    public int c;
    public int d;
    public Object e;
    public JvmProtoBuf$StringTableTypes.Record.Operation f;
    public List g;
    public List h;

    public static c e() {
        c cVar = new c();
        cVar.c = 1;
        cVar.e = "";
        cVar.f = JvmProtoBuf$StringTableTypes.Record.Operation.NONE;
        List list = Collections.EMPTY_LIST;
        cVar.g = list;
        cVar.h = list;
        return cVar;
    }

    @Override // H8.j
    public final AbstractC0241b a() {
        JvmProtoBuf$StringTableTypes.Record recordD = d();
        if (recordD.isInitialized()) {
            return recordD;
        }
        throw new UninitializedMessageException();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x001b  */
    @Override // H8.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final H8.j b(H8.C0245f r2, H8.h r3) throws java.lang.Throwable {
        /*
            r1 = this;
            r3 = 0
            kotlin.reflect.jvm.internal.impl.metadata.jvm.b r0 = kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$StringTableTypes.Record.n     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
            r0.getClass()     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
            kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$StringTableTypes$Record r0 = new kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$StringTableTypes$Record     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
            r0.<init>(r2)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
            r1.f(r0)
            return r1
        Lf:
            r2 = move-exception
            goto L19
        L11:
            r2 = move-exception
            H8.b r0 = r2.f5100a     // Catch: java.lang.Throwable -> Lf
            kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$StringTableTypes$Record r0 = (kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$StringTableTypes.Record) r0     // Catch: java.lang.Throwable -> Lf
            throw r2     // Catch: java.lang.Throwable -> L17
        L17:
            r2 = move-exception
            r3 = r0
        L19:
            if (r3 == 0) goto L1e
            r1.f(r3)
        L1e:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.jvm.c.b(H8.f, H8.h):H8.j");
    }

    @Override // H8.j
    public final /* bridge */ /* synthetic */ j c(GeneratedMessageLite generatedMessageLite) {
        f((JvmProtoBuf$StringTableTypes.Record) generatedMessageLite);
        return this;
    }

    public final Object clone() {
        c cVarE = e();
        cVarE.f(d());
        return cVarE;
    }

    public final JvmProtoBuf$StringTableTypes.Record d() {
        JvmProtoBuf$StringTableTypes.Record record = new JvmProtoBuf$StringTableTypes.Record(this);
        int i = this.b;
        int i6 = (i & 1) != 1 ? 0 : 1;
        record.c = this.c;
        if ((i & 2) == 2) {
            i6 |= 2;
        }
        record.d = this.d;
        if ((i & 4) == 4) {
            i6 |= 4;
        }
        record.e = this.e;
        if ((i & 8) == 8) {
            i6 |= 8;
        }
        record.f = this.f;
        if ((i & 16) == 16) {
            this.g = Collections.unmodifiableList(this.g);
            this.b &= -17;
        }
        record.g = this.g;
        if ((this.b & 32) == 32) {
            this.h = Collections.unmodifiableList(this.h);
            this.b &= -33;
        }
        record.i = this.h;
        record.b = i6;
        return record;
    }

    public final void f(JvmProtoBuf$StringTableTypes.Record record) {
        if (record == JvmProtoBuf$StringTableTypes.Record.m) {
            return;
        }
        int i = record.b;
        if ((i & 1) == 1) {
            int i6 = record.c;
            this.b = 1 | this.b;
            this.c = i6;
        }
        if ((i & 2) == 2) {
            int i10 = record.d;
            this.b = 2 | this.b;
            this.d = i10;
        }
        if ((i & 4) == 4) {
            this.b |= 4;
            this.e = record.e;
        }
        if ((i & 8) == 8) {
            JvmProtoBuf$StringTableTypes.Record.Operation operation = record.f;
            operation.getClass();
            this.b = 8 | this.b;
            this.f = operation;
        }
        if (!record.g.isEmpty()) {
            if (this.g.isEmpty()) {
                this.g = record.g;
                this.b &= -17;
            } else {
                if ((this.b & 16) != 16) {
                    this.g = new ArrayList(this.g);
                    this.b |= 16;
                }
                this.g.addAll(record.g);
            }
        }
        if (!record.i.isEmpty()) {
            if (this.h.isEmpty()) {
                this.h = record.i;
                this.b &= -33;
            } else {
                if ((this.b & 32) != 32) {
                    this.h = new ArrayList(this.h);
                    this.b |= 32;
                }
                this.h.addAll(record.i);
            }
        }
        this.f774a = this.f774a.c(record.f5091a);
    }
}
