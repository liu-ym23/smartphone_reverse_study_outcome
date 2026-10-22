package com.meizu.aiservice.algorithm.chat;

import android.os.Parcel;
import android.os.Parcelable;
import b.a;
import java.util.ArrayList;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import o2.d;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@a
/* loaded from: classes.dex */
public class LlmChatMessage implements Parcelable {
    public static final Parcelable.Creator<LlmChatMessage> CREATOR = new a3.a(9);
    public static final int ROLE_AI_ASSISTANT = 1;
    public static final int ROLE_SYSTEM = 2;
    public static final int ROLE_TOOL = 3;
    public static final int ROLE_USER = 0;
    private String content;
    private String encoded;
    public ArrayList<String> images;
    private int role;
    private long time;
    public ArrayList<d> tool_calls;

    public LlmChatMessage() {
    }

    public static LlmChatMessage aiMessage(String str) {
        return from(1, str);
    }

    public static LlmChatMessage from(int i8, String str) {
        return new LlmChatMessage(i8, null, str);
    }

    public static LlmChatMessage systemMessage(String str) {
        return from(2, str);
    }

    public static LlmChatMessage userMessage(String str) {
        return from(0, str);
    }

    public void addImage(String str) {
        if (this.images == null) {
            this.images = new ArrayList<>();
        }
        this.images.add(str);
    }

    public void addToolCall(d dVar) {
        if (this.tool_calls == null) {
            this.tool_calls = new ArrayList<>();
        }
        this.tool_calls.add(dVar);
    }

    public void clearImages() {
        this.images = null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getContent() {
        return this.content;
    }

    public String getEncoded() {
        return this.encoded;
    }

    public List<String> getImages() {
        return this.images;
    }

    public int getRole() {
        return this.role;
    }

    public String getRoleName() {
        int i8 = this.role;
        return i8 != 0 ? i8 != 2 ? "assistant" : "system" : "user";
    }

    public String getText() {
        return getContent();
    }

    public long getTime() {
        return this.time;
    }

    public ArrayList<d> getToolCalls() {
        return this.tool_calls;
    }

    public void removeImage(String str) {
        ArrayList<String> arrayList = this.images;
        if (arrayList != null) {
            arrayList.remove(str);
        }
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setEncoded(String str) {
        this.encoded = str;
    }

    public void setImages(ArrayList<String> arrayList) {
        this.images = arrayList;
    }

    public void setToolCalls(ArrayList<d> arrayList) {
        this.tool_calls = arrayList;
    }

    public String toString() {
        return "LlmChatMessage{role=" + this.role + ", encoded='" + this.encoded + "', content='" + this.content + "', time=" + this.time + ", images=" + this.images + AbstractJsonLexerKt.END_OBJ;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i8) {
        parcel.writeInt(this.role);
        parcel.writeString(this.encoded);
        parcel.writeString(this.content);
        parcel.writeLong(this.time);
        parcel.writeStringList(this.images);
        parcel.writeTypedList(this.tool_calls);
    }

    public LlmChatMessage(int i8, String str, String str2) {
        this(i8, str, str2, System.currentTimeMillis());
    }

    public LlmChatMessage(int i8, String str) {
        this(i8, null, str, System.currentTimeMillis());
    }

    public LlmChatMessage(int i8, String str, String str2, long j4) {
        this.role = i8;
        this.encoded = str;
        this.content = str2;
        this.time = j4;
    }

    public LlmChatMessage(Parcel parcel) {
        this.role = parcel.readInt();
        this.encoded = parcel.readString();
        this.content = parcel.readString();
        this.time = parcel.readLong();
        this.images = parcel.createStringArrayList();
        this.tool_calls = parcel.createTypedArrayList(d.CREATOR);
    }
}
