package stepai.android.llm.base;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.stepos.agentframework.adapter.bff.BffConstant;
import java.io.IOException;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import stepai.android.llm.base.Role;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J!\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\r\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lstepai/android/llm/base/RoleAdapter;", "Lcom/google/gson/TypeAdapter;", "Lstepai/android/llm/base/Role;", AppAgent.CONSTRUCT, "()V", "Lcom/google/gson/stream/JsonWriter;", "out", "value", "LC7/r;", "write", "(Lcom/google/gson/stream/JsonWriter;Lstepai/android/llm/base/Role;)V", "Lcom/google/gson/stream/JsonReader;", "in", "read", "(Lcom/google/gson/stream/JsonReader;)Lstepai/android/llm/base/Role;", "llmbase_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RoleAdapter extends TypeAdapter<Role> {
    @Override // com.google.gson.TypeAdapter
    /* renamed from: read, reason: avoid collision after fix types in other method */
    public Role read2(JsonReader in) throws IOException {
        k.f(in, "in");
        String strNextString = in.nextString();
        if (strNextString == null) {
            return null;
        }
        int iHashCode = strNextString.hashCode();
        if (iHashCode == -887328209) {
            if (strNextString.equals("system")) {
                return Role.System.INSTANCE;
            }
            return null;
        }
        if (iHashCode == 3599307) {
            if (strNextString.equals(BffConstant.Role.User)) {
                return Role.User.INSTANCE;
            }
            return null;
        }
        if (iHashCode == 1429828318 && strNextString.equals("assistant")) {
            return Role.Assistant.INSTANCE;
        }
        return null;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter out, Role value) throws IOException {
        k.f(out, "out");
        if (value == null) {
            out.nullValue();
            return;
        }
        String lowerCase = value.getName().toLowerCase(Locale.ROOT);
        k.e(lowerCase, "toLowerCase(...)");
        out.value(lowerCase);
    }
}
