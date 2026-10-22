package v9;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 \u00192\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u001aB\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u000f\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0096\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0004\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0005\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0017¨\u0006\u001b"}, d2 = {"Lv9/i;", "Lv9/g;", "", "", "start", "endInclusive", "<init>", "(II)V", UxipConstants.f30680s, "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(I)Z", "isEmpty", "()Z", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "l", "()Ljava/lang/Integer;", "k", "e", Const.INTENT_KEY_APIKEY, "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: v9.i, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C5680i extends C5678g {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: f, reason: collision with root package name */
    public static final C5680i f42860f = new C5680i(1, 0);

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lv9/i$a;", "", "<init>", "()V", "Lv9/i;", "EMPTY", "Lv9/i;", Const.INTENT_KEY_APIKEY, "()Lv9/i;", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: v9.i$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final C5680i a() {
            return C5680i.f42860f;
        }

        public Companion() {
        }
    }

    public C5680i(int i10, int i11) {
        super(i10, i11, 1);
    }

    @Override // v9.C5678g
    public boolean equals(Object other) {
        if (!(other instanceof C5680i)) {
            return false;
        }
        if (isEmpty() && ((C5680i) other).isEmpty()) {
            return true;
        }
        C5680i c5680i = (C5680i) other;
        return getFirst() == c5680i.getFirst() && getLast() == c5680i.getLast();
    }

    @Override // v9.C5678g
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (getFirst() * 31) + getLast();
    }

    @Override // v9.C5678g
    public boolean isEmpty() {
        return getFirst() > getLast();
    }

    public boolean j(int value) {
        return getFirst() <= value && value <= getLast();
    }

    public Integer k() {
        return Integer.valueOf(getLast());
    }

    public Integer l() {
        return Integer.valueOf(getFirst());
    }

    @Override // v9.C5678g
    public String toString() {
        return getFirst() + ".." + getLast();
    }
}
