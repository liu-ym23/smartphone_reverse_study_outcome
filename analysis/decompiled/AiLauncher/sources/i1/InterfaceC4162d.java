package i1;

import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000f\bf\u0018\u00002\u00060\u0001j\u0002`\u0002J!\u0010\b\u001a\u00020\u00072\b\b\u0001\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000b\u001a\u00020\u00072\b\b\u0001\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\nH&¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\r\u001a\u00020\u00072\b\b\u0001\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u000f\u001a\u00020\u00052\b\b\u0001\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0012\u001a\u00020\u00112\b\b\u0001\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0014\u001a\u00020\n2\b\b\u0001\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0016\u001a\u00020\u00112\b\b\u0001\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0016\u0010\u0013J\u000f\u0010\u0017\u001a\u00020\u0003H&¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u0019\u001a\u00020\n2\b\b\u0001\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0019\u0010\u0015J\u000f\u0010\u001a\u001a\u00020\u0011H&¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0007H&¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0007H&¢\u0006\u0004\b\u001e\u0010\u001dJ\u000f\u0010\u001f\u001a\u00020\u0007H&¢\u0006\u0004\b\u001f\u0010\u001dø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006 À\u0006\u0001"}, d2 = {"Li1/d;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "", "index", "", UxipConstants.f30680s, "LY8/t;", "bindLong", "(IJ)V", "", "H", "(ILjava/lang/String;)V", "bindNull", "(I)V", "getLong", "(I)J", "", "getBoolean", "(I)Z", "X0", "(I)Ljava/lang/String;", "isNull", "getColumnCount", "()I", "getColumnName", "n1", "()Z", "reset", "()V", "clearBindings", "close", "sqlite"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: i1.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public interface InterfaceC4162d extends AutoCloseable {
    void H(int index, String value);

    String X0(int index);

    void bindLong(int index, long value);

    void bindNull(int index);

    void clearBindings();

    @Override // java.lang.AutoCloseable
    void close();

    default boolean getBoolean(int index) {
        return getLong(index) != 0;
    }

    int getColumnCount();

    String getColumnName(int index);

    long getLong(int index);

    boolean isNull(int index);

    boolean n1();

    void reset();
}
