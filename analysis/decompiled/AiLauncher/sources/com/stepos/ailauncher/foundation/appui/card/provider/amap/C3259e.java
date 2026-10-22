package com.stepos.ailauncher.foundation.appui.card.provider.amap;

import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 \u00172\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J'\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ/\u0010\u0012\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0010j\b\u0012\u0004\u0012\u00020\u0003`\u0011H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J1\u0010\u0015\u001a\u00020\t2\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0010j\b\u0012\u0004\u0012\u00020\u0003`\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/e;", "Lcom/google/gson/TypeAdapter;", "", "", "<init>", "()V", "Lcom/google/gson/stream/JsonWriter;", "out", UxipConstants.f30680s, "LY8/t;", Const.INTENT_KEY_UMID, "(Lcom/google/gson/stream/JsonWriter;Ljava/util/List;)V", "Lcom/google/gson/stream/JsonReader;", "reader", Const.INTENT_KEY_PKGNAME, "(Lcom/google/gson/stream/JsonReader;)Ljava/util/List;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "c", "(Lcom/google/gson/stream/JsonReader;Ljava/util/ArrayList;)V", "raw", Const.INTENT_KEY_APIKEY, "(Ljava/util/ArrayList;Ljava/lang/String;)V", "Companion", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.amap.e, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3259e extends TypeAdapter<List<? extends String>> {
    private static final a Companion = new a(null);
    private static final Set<String> URL_KEYS = Z8.Y.j("url", "imageUrl", "src", "link", "picUrl");

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/e$a;", "", "<init>", "()V", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.amap.e$a */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.i iVar) {
            this();
        }

        public a() {
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.amap.e$b */
    public static final /* synthetic */ class b {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[JsonToken.values().length];
            try {
                iArr[JsonToken.STRING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[JsonToken.BEGIN_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[JsonToken.NULL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[JsonToken.BEGIN_ARRAY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public final void a(ArrayList<String> out, String raw) {
        String string = raw != null ? La.H.D1(raw).toString() : null;
        if (string == null) {
            string = "";
        }
        if (string.length() == 0) {
            return;
        }
        if (La.D.X(string, "http://", false, 2, null)) {
            string = "https://" + La.H.R0(string, "http://");
        }
        out.add(string);
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public List<String> read(JsonReader reader) throws IOException {
        kotlin.jvm.internal.p.i(reader, "reader");
        ArrayList<String> arrayList = new ArrayList<>();
        JsonToken jsonTokenPeek = reader.peek();
        int i10 = jsonTokenPeek == null ? -1 : b.$EnumSwitchMapping$0[jsonTokenPeek.ordinal()];
        if (i10 == 1) {
            a(arrayList, reader.nextString());
            return arrayList;
        }
        if (i10 == 2) {
            c(reader, arrayList);
            return arrayList;
        }
        if (i10 == 3) {
            reader.nextNull();
            return arrayList;
        }
        if (i10 != 4) {
            reader.skipValue();
            return arrayList;
        }
        reader.beginArray();
        while (reader.hasNext()) {
            JsonToken jsonTokenPeek2 = reader.peek();
            int i11 = jsonTokenPeek2 == null ? -1 : b.$EnumSwitchMapping$0[jsonTokenPeek2.ordinal()];
            if (i11 == 1) {
                a(arrayList, reader.nextString());
            } else if (i11 == 2) {
                c(reader, arrayList);
            } else if (i11 != 3) {
                reader.skipValue();
            } else {
                reader.nextNull();
            }
        }
        reader.endArray();
        return arrayList;
    }

    public final void c(JsonReader reader, ArrayList<String> out) throws IOException {
        reader.beginObject();
        String str = null;
        while (reader.hasNext()) {
            String strNextName = reader.nextName();
            if (reader.peek() == JsonToken.STRING) {
                String strNextString = reader.nextString();
                if (str == null || La.H.x0(str)) {
                    if (URL_KEYS.contains(strNextName)) {
                        str = strNextString;
                    }
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        a(out, str);
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void write(JsonWriter out, List<String> value) throws IOException {
        kotlin.jvm.internal.p.i(out, "out");
        if (value == null) {
            out.nullValue();
            return;
        }
        out.beginArray();
        Iterator<T> it = value.iterator();
        while (it.hasNext()) {
            out.value((String) it.next());
        }
        out.endArray();
    }
}
