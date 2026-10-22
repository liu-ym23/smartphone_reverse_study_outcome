package v4;

import La.H;
import android.net.Uri;
import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import h8.C4148a;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J!\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\r\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lv4/f;", "Lcom/google/gson/TypeAdapter;", "Landroid/net/Uri;", "<init>", "()V", "Lcom/google/gson/stream/JsonWriter;", "out", UxipConstants.f30680s, "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Lcom/google/gson/stream/JsonWriter;Landroid/net/Uri;)V", "Lcom/google/gson/stream/JsonReader;", "in", Const.INTENT_KEY_APIKEY, "(Lcom/google/gson/stream/JsonReader;)Landroid/net/Uri;", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class f extends TypeAdapter<Uri> {
    @Override // com.google.gson.TypeAdapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Uri read(JsonReader in) throws IOException {
        p.i(in, "in");
        if (in.peek() == JsonToken.NULL) {
            in.nextNull();
            return null;
        }
        try {
            String strNextString = in.nextString();
            p.f(strNextString);
            if (H.x0(strNextString)) {
                return null;
            }
            return Uri.parse(strNextString);
        } catch (Exception e10) {
            C4148a.g("UriTypeAdapter", "解析 Uri 失败", e10, false, 8, null);
            return null;
        }
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void write(JsonWriter out, Uri value) throws IOException {
        p.i(out, "out");
        if (value == null) {
            out.nullValue();
        } else {
            out.value(value.toString());
        }
    }
}
