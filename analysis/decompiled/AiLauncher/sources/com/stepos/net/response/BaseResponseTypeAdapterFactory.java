package com.stepos.net.response;

import Z8.Y;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \r2\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J7\u0010\u000b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\n\"\b\b\u0000\u0010\u0005*\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/stepos/net/response/BaseResponseTypeAdapterFactory;", "Lcom/google/gson/TypeAdapterFactory;", "<init>", "()V", "", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/google/gson/Gson;", "gson", "Lcom/google/gson/reflect/TypeToken;", "type", "Lcom/google/gson/TypeAdapter;", "create", "(Lcom/google/gson/Gson;Lcom/google/gson/reflect/TypeToken;)Lcom/google/gson/TypeAdapter;", "Companion", Const.INTENT_KEY_APIKEY, "net_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class BaseResponseTypeAdapterFactory implements TypeAdapterFactory {
    private static final a Companion = new a(null);
    private static final Set<String> DATA_KEYS = Y.j("data", "result", "payload");

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/stepos/net/response/BaseResponseTypeAdapterFactory$a;", "", "<init>", "()V", "", "", "DATA_KEYS", "Ljava/util/Set;", Const.INTENT_KEY_APIKEY, "()Ljava/util/Set;", "net_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a {
        public /* synthetic */ a(i iVar) {
            this();
        }

        public final Set<String> a() {
            return BaseResponseTypeAdapterFactory.DATA_KEYS;
        }

        public a() {
        }
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
        p.i(gson, "gson");
        p.i(type, "type");
        if (!BaseResponse.class.isAssignableFrom(type.getRawType())) {
            return null;
        }
        final TypeAdapter<T> delegateAdapter = gson.getDelegateAdapter(this, type);
        final TypeAdapter<T> adapter = gson.getAdapter(JsonElement.class);
        p.h(adapter, "getAdapter(...)");
        TypeAdapter<T> typeAdapterNullSafe = new TypeAdapter<T>() { // from class: com.stepos.net.response.BaseResponseTypeAdapterFactory.create.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.gson.TypeAdapter
            public T read(JsonReader in) throws IOException {
                T tFromJsonTree;
                p.i(in, "in");
                JsonElement jsonElement = adapter.read(in);
                if (jsonElement == null || (tFromJsonTree = delegateAdapter.fromJsonTree(jsonElement)) == 0) {
                    return null;
                }
                if ((tFromJsonTree instanceof BaseResponse) && (jsonElement instanceof JsonObject)) {
                    BaseResponse baseResponse = (BaseResponse) tFromJsonTree;
                    Set<String> setA = BaseResponseTypeAdapterFactory.Companion.a();
                    boolean z10 = false;
                    if (!(setA instanceof Collection) || !setA.isEmpty()) {
                        Iterator<T> it = setA.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            if (((JsonObject) jsonElement).has((String) it.next())) {
                                z10 = true;
                                break;
                            }
                        }
                    }
                    baseResponse.setHasData$net_release(z10);
                }
                return tFromJsonTree;
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter out, T value) throws IOException {
                p.i(out, "out");
                delegateAdapter.write(out, value);
            }
        }.nullSafe();
        p.g(typeAdapterNullSafe, "null cannot be cast to non-null type com.google.gson.TypeAdapter<T of com.stepos.net.response.BaseResponseTypeAdapterFactory.create>");
        return typeAdapterNullSafe;
    }
}
