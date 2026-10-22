package com.uxsense.core.base.parse;

import A9.d;
import B9.d0;
import androidx.constraintlayout.core.dsl.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;
import x9.b;
import z9.g;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u001c\b\u0087\b\u0018\u0000 82\u00020\u0001:\u000298B/\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bB;\b\u0010\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0007\u0010\fJ'\u0010\u0015\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b#\u0010\"J\u0010\u0010$\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b$\u0010\"J\u0010\u0010%\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b%\u0010\"J8\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b&\u0010'J\u0010\u0010(\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b(\u0010\"J\u001a\u0010)\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b)\u0010*R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010+\u001a\u0004\b,\u0010\"R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010+\u001a\u0004\b-\u0010\"R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010+\u001a\u0004\b.\u0010\"R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010+\u001a\u0004\b/\u0010\"R\u0011\u00101\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b0\u0010\"R\u0011\u00103\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b2\u0010\"R\u0011\u00105\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b4\u0010\"R\u0011\u00107\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b6\u0010\"¨\u0006:"}, d2 = {"Lcom/uxsense/core/base/parse/KRect;", "", "", "left", "top", "right", "bottom", AppAgent.CONSTRUCT, "(IIII)V", "seen0", "LB9/d0;", "serializationConstructorMarker", "(IIIIILB9/d0;)V", "self", "LA9/d;", "output", "Lz9/g;", "serialDesc", "LC7/r;", "write$Self$uxsense_release", "(Lcom/uxsense/core/base/parse/KRect;LA9/d;Lz9/g;)V", "write$Self", "x", "y", "", "contains", "(II)Z", "other", "intersects", "(Lcom/uxsense/core/base/parse/KRect;)Z", "", "toString", "()Ljava/lang/String;", "component1", "()I", "component2", "component3", "component4", "copy", "(IIII)Lcom/uxsense/core/base/parse/KRect;", "hashCode", "equals", "(Ljava/lang/Object;)Z", "I", "getLeft", "getTop", "getRight", "getBottom", "getWidth", "width", "getHeight", "height", "getCenterX", "centerX", "getCenterY", "centerY", "Companion", "$serializer", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class KRect {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int bottom;
    private final int left;
    private final int right;
    private final int top;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/uxsense/core/base/parse/KRect$Companion;", "", AppAgent.CONSTRUCT, "()V", "Lx9/b;", "Lcom/uxsense/core/base/parse/KRect;", "serializer", "()Lx9/b;", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public final b serializer() {
            return KRect$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(e eVar) {
            this();
        }
    }

    public KRect() {
        this(0, 0, 0, 0, 15, (e) null);
    }

    public static /* synthetic */ KRect copy$default(KRect kRect, int i, int i6, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i = kRect.left;
        }
        if ((i12 & 2) != 0) {
            i6 = kRect.top;
        }
        if ((i12 & 4) != 0) {
            i10 = kRect.right;
        }
        if ((i12 & 8) != 0) {
            i11 = kRect.bottom;
        }
        return kRect.copy(i, i6, i10, i11);
    }

    public static final /* synthetic */ void write$Self$uxsense_release(KRect self, d output, g serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.left != 0) {
            output.encodeIntElement(serialDesc, 0, self.left);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.top != 0) {
            output.encodeIntElement(serialDesc, 1, self.top);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.right != 0) {
            output.encodeIntElement(serialDesc, 2, self.right);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 3) && self.bottom == 0) {
            return;
        }
        output.encodeIntElement(serialDesc, 3, self.bottom);
    }

    /* renamed from: component1, reason: from getter */
    public final int getLeft() {
        return this.left;
    }

    /* renamed from: component2, reason: from getter */
    public final int getTop() {
        return this.top;
    }

    /* renamed from: component3, reason: from getter */
    public final int getRight() {
        return this.right;
    }

    /* renamed from: component4, reason: from getter */
    public final int getBottom() {
        return this.bottom;
    }

    public final boolean contains(int x10, int y) {
        int i = this.left;
        if (x10 > this.right || i > x10) {
            return false;
        }
        return y <= this.bottom && this.top <= y;
    }

    public final KRect copy(int left, int top, int right, int bottom) {
        return new KRect(left, top, right, bottom);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof KRect)) {
            return false;
        }
        KRect kRect = (KRect) other;
        return this.left == kRect.left && this.top == kRect.top && this.right == kRect.right && this.bottom == kRect.bottom;
    }

    public final int getBottom() {
        return this.bottom;
    }

    public final int getCenterX() {
        return (this.left + this.right) / 2;
    }

    public final int getCenterY() {
        return (this.top + this.bottom) / 2;
    }

    public final int getHeight() {
        return this.bottom - this.top;
    }

    public final int getLeft() {
        return this.left;
    }

    public final int getRight() {
        return this.right;
    }

    public final int getTop() {
        return this.top;
    }

    public final int getWidth() {
        return this.right - this.left;
    }

    public int hashCode() {
        return Integer.hashCode(this.bottom) + a.a(this.right, a.a(this.top, Integer.hashCode(this.left) * 31, 31), 31);
    }

    public final boolean intersects(KRect other) {
        k.f(other, "other");
        return this.left < other.right && this.right > other.left && this.top < other.bottom && this.bottom > other.top;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("bounds:{");
        sb.append(this.left);
        sb.append(", ");
        sb.append(this.top);
        sb.append(", ");
        sb.append(this.right);
        sb.append(", ");
        return B7.a.o(sb, this.bottom, '}');
    }

    public /* synthetic */ KRect(int i, int i6, int i10, int i11, int i12, d0 d0Var) {
        if ((i & 1) == 0) {
            this.left = 0;
        } else {
            this.left = i6;
        }
        if ((i & 2) == 0) {
            this.top = 0;
        } else {
            this.top = i10;
        }
        if ((i & 4) == 0) {
            this.right = 0;
        } else {
            this.right = i11;
        }
        if ((i & 8) == 0) {
            this.bottom = 0;
        } else {
            this.bottom = i12;
        }
    }

    public KRect(int i, int i6, int i10, int i11) {
        this.left = i;
        this.top = i6;
        this.right = i10;
        this.bottom = i11;
    }

    public /* synthetic */ KRect(int i, int i6, int i10, int i11, int i12, e eVar) {
        this((i12 & 1) != 0 ? 0 : i, (i12 & 2) != 0 ? 0 : i6, (i12 & 4) != 0 ? 0 : i10, (i12 & 8) != 0 ? 0 : i11);
    }
}
