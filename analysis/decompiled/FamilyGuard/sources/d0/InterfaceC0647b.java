package d0;

import android.content.ContentValues;
import android.database.Cursor;
import android.util.Pair;
import java.io.Closeable;
import java.util.List;

/* renamed from: d0.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public interface InterfaceC0647b extends Closeable {
    void B();

    long M(String str, int i5, ContentValues contentValues);

    void P();

    Cursor a0(InterfaceC0650e interfaceC0650e);

    Cursor d(String str);

    String f0();

    void g();

    List<Pair<String, String>> h();

    boolean i0();

    boolean isOpen();

    void k(String str);

    InterfaceC0651f p(String str);
}
