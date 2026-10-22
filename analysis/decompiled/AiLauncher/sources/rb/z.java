package rb;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;
import kotlinx.serialization.json.internal.WriteMode;
import qb.AbstractC5171a;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a;\u0010\t\u001a\u00020\b\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\u0006\u0010\u0007\u001a\u00028\u0000H\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lqb/a;", "json", "Lrb/q;", "writer", "Llb/m;", "serializer", UxipConstants.f30680s, "LY8/t;", Const.INTENT_KEY_APIKEY, "(Lqb/a;Lrb/q;Llb/m;Ljava/lang/Object;)V", "kotlinx-serialization-json"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class z {
    public static final <T> void a(AbstractC5171a json, InterfaceC5267q writer, lb.m<? super T> serializer, T t10) {
        kotlin.jvm.internal.p.i(json, "json");
        kotlin.jvm.internal.p.i(writer, "writer");
        kotlin.jvm.internal.p.i(serializer, "serializer");
        new J(writer, json, WriteMode.OBJ, new qb.s[WriteMode.getEntries().size()]).e(serializer, t10);
    }
}
