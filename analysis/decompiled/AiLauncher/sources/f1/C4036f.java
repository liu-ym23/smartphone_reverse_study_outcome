package f1;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import i1.InterfaceC4162d;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010$\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\"\u0010\u000b\u001a\u00020\n2\b\b\u0001\u0010\u0007\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0096\u0001¢\u0006\u0004\b\u000b\u0010\fJ\"\u0010\r\u001a\u00020\n2\b\b\u0001\u0010\u0007\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002H\u0096\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u000f\u001a\u00020\n2\b\b\u0001\u0010\u0007\u001a\u00020\u0004H\u0096\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0011\u001a\u00020\b2\b\b\u0001\u0010\u0007\u001a\u00020\u0004H\u0096\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0014\u001a\u00020\u00132\b\b\u0001\u0010\u0007\u001a\u00020\u0004H\u0096\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0016\u001a\u00020\u00022\b\b\u0001\u0010\u0007\u001a\u00020\u0004H\u0096\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u0018\u001a\u00020\u00132\b\b\u0001\u0010\u0007\u001a\u00020\u0004H\u0096\u0001¢\u0006\u0004\b\u0018\u0010\u0015J\u0010\u0010\u0019\u001a\u00020\u0004H\u0096\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001b\u001a\u00020\u00022\b\b\u0001\u0010\u0007\u001a\u00020\u0004H\u0096\u0001¢\u0006\u0004\b\u001b\u0010\u0017J\u0010\u0010\u001c\u001a\u00020\u0013H\u0096\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\nH\u0096\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\nH\u0096\u0001¢\u0006\u0004\b \u0010\u001fJ\u0010\u0010!\u001a\u00020\nH\u0096\u0001¢\u0006\u0004\b!\u0010\u001fR\u0014\u0010$\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R \u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'¨\u0006)"}, d2 = {"Lf1/f;", "Li1/d;", "", "name", "", "getColumnIndex", "(Ljava/lang/String;)I", "index", "", UxipConstants.f30680s, "LY8/t;", "bindLong", "(IJ)V", "H", "(ILjava/lang/String;)V", "bindNull", "(I)V", "getLong", "(I)J", "", "getBoolean", "(I)Z", "X0", "(I)Ljava/lang/String;", "isNull", "getColumnCount", "()I", "getColumnName", "n1", "()Z", "reset", "()V", "clearBindings", "close", Const.INTENT_KEY_APIKEY, "Li1/d;", "delegate", "", Const.INTENT_KEY_PKGNAME, "Ljava/util/Map;", "columnNameToIndexMap", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: f1.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C4036f implements InterfaceC4162d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC4162d delegate;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final Map<String, Integer> columnNameToIndexMap;

    @Override // i1.InterfaceC4162d
    public void H(int index, String value) {
        p.i(value, "value");
        this.delegate.H(index, value);
    }

    @Override // i1.InterfaceC4162d
    public String X0(int index) {
        return this.delegate.X0(index);
    }

    @Override // i1.InterfaceC4162d
    public void bindLong(int index, long value) {
        this.delegate.bindLong(index, value);
    }

    @Override // i1.InterfaceC4162d
    public void bindNull(int index) {
        this.delegate.bindNull(index);
    }

    @Override // i1.InterfaceC4162d
    public void clearBindings() {
        this.delegate.clearBindings();
    }

    @Override // i1.InterfaceC4162d, java.lang.AutoCloseable
    public void close() {
        this.delegate.close();
    }

    @Override // i1.InterfaceC4162d
    public boolean getBoolean(int index) {
        return this.delegate.getBoolean(index);
    }

    @Override // i1.InterfaceC4162d
    public int getColumnCount() {
        return this.delegate.getColumnCount();
    }

    public final int getColumnIndex(String name) {
        p.i(name, "name");
        Integer num = this.columnNameToIndexMap.get(name);
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }

    @Override // i1.InterfaceC4162d
    public String getColumnName(int index) {
        return this.delegate.getColumnName(index);
    }

    @Override // i1.InterfaceC4162d
    public long getLong(int index) {
        return this.delegate.getLong(index);
    }

    @Override // i1.InterfaceC4162d
    public boolean isNull(int index) {
        return this.delegate.isNull(index);
    }

    @Override // i1.InterfaceC4162d
    public boolean n1() {
        return this.delegate.n1();
    }

    @Override // i1.InterfaceC4162d
    public void reset() {
        this.delegate.reset();
    }
}
