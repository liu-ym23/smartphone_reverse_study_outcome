package q0;

import androidx.recyclerview.widget.RecyclerView;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.sql.Clob;
import java.sql.SQLException;

/* renamed from: q0.s, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0971s implements U {

    /* renamed from: a, reason: collision with root package name */
    public static final C0971s f19874a = new C0971s();

    @Override // q0.U
    public void b(C0946I c0946i, Object obj, Object obj2, Type type, int i5) throws SQLException, IOException {
        try {
            if (obj == null) {
                c0946i.I();
                return;
            }
            Reader characterStream = ((Clob) obj).getCharacterStream();
            StringBuilder sb = new StringBuilder();
            try {
                char[] cArr = new char[RecyclerView.ItemAnimator.FLAG_MOVED];
                while (true) {
                    int i6 = characterStream.read(cArr, 0, RecyclerView.ItemAnimator.FLAG_MOVED);
                    if (i6 < 0) {
                        String string = sb.toString();
                        characterStream.close();
                        c0946i.H(string);
                        return;
                    }
                    sb.append(cArr, 0, i6);
                }
            } catch (Exception e6) {
                throw new l0.d("read string from reader error", e6);
            }
        } catch (SQLException e7) {
            throw new IOException("write clob error", e7);
        }
    }
}
