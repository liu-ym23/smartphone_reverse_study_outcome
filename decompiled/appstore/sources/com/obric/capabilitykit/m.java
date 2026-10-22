package com.obric.capabilitykit;

import com.bytedance.apm.constant.CommonKey;
import com.tmall.wireless.tangram.structure.card.SlideCard;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/obric/capabilitykit/entity/ActionType;", "", "", "action", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "Ljava/lang/String;", "getAction", "()Ljava/lang/String;", "Companion", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final enum m extends Enum<m> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public static final a f11370b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final m f11371c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final m f11372d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ m[] f11373e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final String f11374a;

    public static final class a {
        public a() {
        }

        public final m a(String r10) {
            kotlin.jvm.internal.q.g(r10, CommonKey.KEY_VALUE);
            m[] r11 = m.values();
            int r12 = 0;
        L4:
            if (r12 >= 2) goto L9;
            m r13 = r11[r12];
            if (kotlin.jvm.internal.q.b(r13.b(), r10) == true) goto L13;
            r12 = r12 + 1;
            goto L4
        L13:
            return r13;
        L9:
            return null;
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        f11371c = new m("INDEX", 0, SlideCard.KEY_INDEX);
        f11372d = new m("DELETE", 1, "delete");
        f11373e = a();
        f11370b = new a(null);
    }

    private m(String r10, int r11, String r12) {
        super(r10, r11);
        this.f11374a = r12;
    }

    private static final /* synthetic */ m[] a() {
        return new m[]{f11371c, f11372d};
    }

    public static m valueOf(String r10) {
        return (m) Enum.valueOf(m.class, r10);
    }

    public static m[] values() {
        return (m[]) f11373e.clone();
    }

    @NotNull
    public final String b() {
        return this.f11374a;
    }
}
