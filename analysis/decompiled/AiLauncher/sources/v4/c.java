package v4;

import android.net.Uri;
import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.stepos.ame.sdk.SkillStoreKt;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.p;
import u4.m;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J!\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lv4/c;", "Lcom/google/gson/TypeAdapter;", "Lu4/m;", "<init>", "()V", "Lcom/google/gson/stream/JsonWriter;", "out", UxipConstants.f30680s, "LY8/t;", "c", "(Lcom/google/gson/stream/JsonWriter;Lu4/m;)V", "Lcom/google/gson/stream/JsonReader;", "in", Const.INTENT_KEY_PKGNAME, "(Lcom/google/gson/stream/JsonReader;)Lu4/m;", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "", Const.INTENT_KEY_APIKEY, "(Lu4/m;)Ljava/lang/String;", "TYPE_FIELD", "Ljava/lang/String;", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class c extends TypeAdapter<m> {
    private final String TYPE_FIELD = "type";

    public final String a(m content) {
        if (content instanceof m.TextMessage) {
            return "TextMessage";
        }
        if (content instanceof m.ImageMessage) {
            return "ImageMessage";
        }
        if (content instanceof m.FileMessage) {
            return "FileMessage";
        }
        if (content instanceof m.FolderMessage) {
            return "FolderMessage";
        }
        if (content instanceof m.VideoMessage) {
            return "VideoMessage";
        }
        if (content instanceof m.AudioMessage) {
            return "AudioMessage";
        }
        if (content instanceof m.AudioStreamMessage) {
            return "AudioStreamMessage";
        }
        if (content instanceof m.TaskMessage) {
            return "TaskMessage";
        }
        if (content instanceof m.InquiryMessage) {
            return "InquiryMessage";
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    @Override // com.google.gson.TypeAdapter
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public m read(JsonReader in) throws JsonSyntaxException, JsonIOException, IOException {
        p.i(in, "in");
        Gson gsonCreate = new GsonBuilder().registerTypeAdapter(Uri.class, new f()).serializeNulls().create();
        in.beginObject();
        String strNextString = null;
        JsonElement reader = null;
        while (in.hasNext()) {
            String strNextName = in.nextName();
            if (p.d(strNextName, this.TYPE_FIELD)) {
                strNextString = in.nextString();
            } else if (p.d(strNextName, "data")) {
                reader = JsonParser.parseReader(in);
            }
        }
        in.endObject();
        if (strNextString != null) {
            switch (strNextString.hashCode()) {
                case -467111055:
                    if (strNextString.equals("AudioMessage")) {
                        Object objFromJson = gsonCreate.fromJson(reader, (Class<Object>) m.AudioMessage.class);
                        p.h(objFromJson, "fromJson(...)");
                        return (m) objFromJson;
                    }
                    break;
                case 215857826:
                    if (strNextString.equals("TaskMessage")) {
                        Object objFromJson2 = gsonCreate.fromJson(reader, (Class<Object>) m.TaskMessage.class);
                        p.h(objFromJson2, "fromJson(...)");
                        return (m) objFromJson2;
                    }
                    break;
                case 226584267:
                    if (strNextString.equals("FileMessage")) {
                        Object objFromJson3 = gsonCreate.fromJson(reader, (Class<Object>) m.FileMessage.class);
                        p.h(objFromJson3, "fromJson(...)");
                        return (m) objFromJson3;
                    }
                    break;
                case 678392729:
                    if (strNextString.equals("FolderMessage")) {
                        Object objFromJson4 = gsonCreate.fromJson(reader, (Class<Object>) m.FolderMessage.class);
                        p.h(objFromJson4, "fromJson(...)");
                        return (m) objFromJson4;
                    }
                    break;
                case 848139345:
                    if (strNextString.equals("AudioStreamMessage")) {
                        Object objFromJson5 = gsonCreate.fromJson(reader, (Class<Object>) m.AudioStreamMessage.class);
                        p.h(objFromJson5, "fromJson(...)");
                        return (m) objFromJson5;
                    }
                    break;
                case 972089132:
                    if (strNextString.equals("VideoMessage")) {
                        Object objFromJson6 = gsonCreate.fromJson(reader, (Class<Object>) m.VideoMessage.class);
                        p.h(objFromJson6, "fromJson(...)");
                        return (m) objFromJson6;
                    }
                    break;
                case 1151704160:
                    if (strNextString.equals("InquiryMessage")) {
                        Object objFromJson7 = gsonCreate.fromJson(reader, (Class<Object>) m.InquiryMessage.class);
                        p.h(objFromJson7, "fromJson(...)");
                        return (m) objFromJson7;
                    }
                    break;
                case 1717507660:
                    if (strNextString.equals("ImageMessage")) {
                        Object objFromJson8 = gsonCreate.fromJson(reader, (Class<Object>) m.ImageMessage.class);
                        p.h(objFromJson8, "fromJson(...)");
                        return (m) objFromJson8;
                    }
                    break;
                case 1782857210:
                    if (strNextString.equals("TextMessage")) {
                        Object objFromJson9 = gsonCreate.fromJson(reader, (Class<Object>) m.TextMessage.class);
                        p.h(objFromJson9, "fromJson(...)");
                        return (m) objFromJson9;
                    }
                    break;
            }
        }
        throw new JsonSyntaxException("Unknown MessageContent type: " + strNextString);
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void write(JsonWriter out, m value) throws JsonIOException, IOException {
        p.i(out, "out");
        if (value == null) {
            out.nullValue();
            return;
        }
        Gson gsonCreate = new GsonBuilder().registerTypeAdapter(Uri.class, new f()).serializeNulls().create();
        out.beginObject();
        out.name(this.TYPE_FIELD).value(a(value));
        out.name("data");
        gsonCreate.toJson(value, value.getClass(), out);
        out.endObject();
    }
}
