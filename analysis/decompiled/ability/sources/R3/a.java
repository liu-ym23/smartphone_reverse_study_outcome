package R3;

import androidx.compose.ui.text.MultiParagraph;
import androidx.compose.ui.text.ParagraphInfo;
import androidx.sqlite.SQLiteConnection;
import com.stepos.ability.database.dao.AbilityDao_Impl;
import java.io.Serializable;
import kotlin.jvm.internal.Ref$FloatRef;
import kotlin.jvm.internal.Ref$IntRef;

/* loaded from: classes3.dex */
public final /* synthetic */ class a implements S7.k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1142a;
    public final /* synthetic */ Serializable b;
    public final /* synthetic */ long c;
    public final /* synthetic */ Serializable d;
    public final /* synthetic */ Serializable e;

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ a(long j5, float[] fArr, Ref$IntRef ref$IntRef, Ref$FloatRef ref$FloatRef) {
        this.f1142a = 2;
        this.c = j5;
        this.b = fArr;
        this.d = ref$IntRef;
        this.e = ref$FloatRef;
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        switch (this.f1142a) {
            case 0:
                return AbilityDao_Impl.updateSyncStatus$lambda$0("UPDATE t_ability SET syncStatus = ?, updateTime = ? WHERE packageName = ? AND syncStatus = ? ", (String) this.b, this.c, (String) this.d, (String) this.e, (SQLiteConnection) obj);
            case 1:
                return AbilityDao_Impl.updateStatus$lambda$0("UPDATE t_ability SET status = ?, updateTime = ? WHERE packageName = ? AND status = ? ", (String) this.b, this.c, (String) this.d, (String) this.e, (SQLiteConnection) obj);
            default:
                return MultiParagraph.fillBoundingBoxes_8ffj60Q$lambda$19(this.c, (float[]) this.b, (Ref$IntRef) this.d, (Ref$FloatRef) this.e, (ParagraphInfo) obj);
        }
    }

    public /* synthetic */ a(String str, int i, String str2, String str3, long j5) {
        this.f1142a = i;
        this.b = str;
        this.c = j5;
        this.d = str2;
        this.e = str3;
    }
}
