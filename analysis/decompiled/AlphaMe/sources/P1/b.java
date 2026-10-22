package P1;

import com.stepos.alphame.awareness.AwarenessDataItem;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: b, reason: collision with root package name */
    public final char f1570b;

    /* renamed from: d, reason: collision with root package name */
    public boolean f1572d;

    /* renamed from: e, reason: collision with root package name */
    public Object f1573e;

    /* renamed from: a, reason: collision with root package name */
    public int f1569a = 0;

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f1571c = new HashMap();

    public b(char c4) {
        this.f1570b = c4;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(this.f1570b);
        if (this.f1573e != null) {
            sb.append(AwarenessDataItem.USERID_SPLITTER);
            sb.append(this.f1573e);
        }
        return sb.toString();
    }
}
