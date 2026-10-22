package v9;

import Z8.AbstractC1171t;
import com.autonavi.aps.amapapi.AMapLocationStaticsEntity;
import com.autonavi.aps.amapapi.config.Const;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tH\u0096\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\f\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u000eR\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0016\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u000e¨\u0006\u0017"}, d2 = {"Lv9/b;", "LZ8/t;", "", AMapLocationStaticsEntity.FIRST_LOCATE, "last", "", "step", "<init>", "(CCI)V", "", "hasNext", "()Z", Const.INTENT_KEY_APIKEY, "()C", "I", "getStep", "()I", Const.INTENT_KEY_PKGNAME, "finalElement", "c", "Z", Const.INTENT_KEY_UMID, "next", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: v9.b, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C5673b extends AbstractC1171t {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final int step;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final int finalElement;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public boolean hasNext;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public int next;

    public C5673b(char c10, char c11, int i10) {
        this.step = i10;
        this.finalElement = c11;
        boolean z10 = false;
        if (i10 <= 0 ? p.k(c10, c11) >= 0 : p.k(c10, c11) <= 0) {
            z10 = true;
        }
        this.hasNext = z10;
        this.next = z10 ? c10 : c11;
    }

    @Override // Z8.AbstractC1171t
    public char a() {
        int i10 = this.next;
        if (i10 != this.finalElement) {
            this.next = this.step + i10;
        } else {
            if (!this.hasNext) {
                throw new NoSuchElementException();
            }
            this.hasNext = false;
        }
        return (char) i10;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.hasNext;
    }
}
