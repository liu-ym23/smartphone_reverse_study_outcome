package com.stepos.core.data;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.stepos.core.data.base.Content;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.a;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class LlmChatMessage implements Parcelable {
    public static final int ROLE_AI_ASSISTANT = 1;
    public static final int ROLE_ASSISTANT = 1;
    public static final int ROLE_SYSTEM = 2;
    public static final int ROLE_TOOL = 3;
    public static final int ROLE_USER = 0;
    private final String content;
    private final List<Bitmap> imageBitmaps;
    private final List<ParcelFileDescriptor> imageFds;
    private List<String> images;
    private final int role;
    private final String toolCallId;
    private final List<LlmToolCall> toolCalls;
    public static final Companion Companion = new Companion(null);
    public static final Parcelable.Creator<LlmChatMessage> CREATOR = new Creator();

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final LlmChatMessage aiMessage(String content) {
            g.f(content, "content");
            return assistant(content);
        }

        public final LlmChatMessage assistant(String content) {
            g.f(content, "content");
            return new LlmChatMessage(1, content, null, null, null, null, null, 124, null);
        }

        public final LlmChatMessage system(String content) {
            g.f(content, "content");
            return new LlmChatMessage(2, content, null, null, null, null, null, 124, null);
        }

        public final LlmChatMessage systemMessage(String content) {
            g.f(content, "content");
            return system(content);
        }

        public final LlmChatMessage tool(String toolCallId, String content) {
            g.f(toolCallId, "toolCallId");
            g.f(content, "content");
            return new LlmChatMessage(3, content, null, null, null, null, toolCallId, 60, null);
        }

        public final LlmChatMessage user(String content) {
            g.f(content, "content");
            return new LlmChatMessage(0, content, null, null, null, null, null, 124, null);
        }

        public final LlmChatMessage userMessage(String content) {
            g.f(content, "content");
            return user(content);
        }

        public final LlmChatMessage userWithBitmaps(String content, List<Bitmap> imageBitmaps) {
            g.f(content, "content");
            g.f(imageBitmaps, "imageBitmaps");
            return new LlmChatMessage(0, content, null, null, imageBitmaps, null, null, Content.Types.TYPE_DOUBLE_ARRAY, null);
        }

        public final LlmChatMessage userWithFds(String content, List<? extends ParcelFileDescriptor> imageFds) {
            g.f(content, "content");
            g.f(imageFds, "imageFds");
            return new LlmChatMessage(0, content, null, imageFds, null, null, null, 116, null);
        }

        private Companion() {
        }

        public final LlmChatMessage assistant(List<LlmToolCall> toolCalls) {
            g.f(toolCalls, "toolCalls");
            return new LlmChatMessage(1, null, null, null, null, toolCalls, null, 94, null);
        }

        public final LlmChatMessage user(String content, List<String> images) {
            g.f(content, "content");
            g.f(images, "images");
            return new LlmChatMessage(0, content, a.P0(images), null, null, null, null, 120, null);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Creator implements Parcelable.Creator<LlmChatMessage> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final LlmChatMessage createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            ArrayList arrayList2;
            g.f(parcel, "parcel");
            int i10 = parcel.readInt();
            String string = parcel.readString();
            ArrayList<String> arrayListCreateStringArrayList = parcel.createStringArrayList();
            ArrayList arrayList3 = null;
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int i11 = parcel.readInt();
                arrayList = new ArrayList(i11);
                for (int i12 = 0; i12 != i11; i12++) {
                    arrayList.add(parcel.readParcelable(LlmChatMessage.class.getClassLoader()));
                }
            }
            if (parcel.readInt() == 0) {
                arrayList2 = null;
            } else {
                int i13 = parcel.readInt();
                arrayList2 = new ArrayList(i13);
                for (int i14 = 0; i14 != i13; i14++) {
                    arrayList2.add(parcel.readParcelable(LlmChatMessage.class.getClassLoader()));
                }
            }
            if (parcel.readInt() != 0) {
                int i15 = parcel.readInt();
                arrayList3 = new ArrayList(i15);
                for (int i16 = 0; i16 != i15; i16++) {
                    arrayList3.add(LlmToolCall.CREATOR.createFromParcel(parcel));
                }
            }
            return new LlmChatMessage(i10, string, arrayListCreateStringArrayList, arrayList, arrayList2, arrayList3, parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final LlmChatMessage[] newArray(int i10) {
            return new LlmChatMessage[i10];
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LlmChatMessage(int i10, String str, List<String> list, List<? extends ParcelFileDescriptor> list2, List<Bitmap> list3, List<LlmToolCall> list4, String str2) {
        this.role = i10;
        this.content = str;
        this.images = list;
        this.imageFds = list2;
        this.imageBitmaps = list3;
        this.toolCalls = list4;
        this.toolCallId = str2;
    }

    public static final LlmChatMessage aiMessage(String str) {
        return Companion.aiMessage(str);
    }

    public static final LlmChatMessage assistant(String str) {
        return Companion.assistant(str);
    }

    public static /* synthetic */ LlmChatMessage copy$default(LlmChatMessage llmChatMessage, int i10, String str, List list, List list2, List list3, List list4, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = llmChatMessage.role;
        }
        if ((i11 & 2) != 0) {
            str = llmChatMessage.content;
        }
        if ((i11 & 4) != 0) {
            list = llmChatMessage.images;
        }
        if ((i11 & 8) != 0) {
            list2 = llmChatMessage.imageFds;
        }
        if ((i11 & 16) != 0) {
            list3 = llmChatMessage.imageBitmaps;
        }
        if ((i11 & 32) != 0) {
            list4 = llmChatMessage.toolCalls;
        }
        if ((i11 & 64) != 0) {
            str2 = llmChatMessage.toolCallId;
        }
        List list5 = list4;
        String str3 = str2;
        List list6 = list3;
        List list7 = list;
        return llmChatMessage.copy(i10, str, list7, list2, list6, list5, str3);
    }

    public static final LlmChatMessage system(String str) {
        return Companion.system(str);
    }

    public static final LlmChatMessage systemMessage(String str) {
        return Companion.systemMessage(str);
    }

    public static final LlmChatMessage tool(String str, String str2) {
        return Companion.tool(str, str2);
    }

    public static final LlmChatMessage user(String str) {
        return Companion.user(str);
    }

    public static final LlmChatMessage userMessage(String str) {
        return Companion.userMessage(str);
    }

    public static final LlmChatMessage userWithBitmaps(String str, List<Bitmap> list) {
        return Companion.userWithBitmaps(str, list);
    }

    public static final LlmChatMessage userWithFds(String str, List<? extends ParcelFileDescriptor> list) {
        return Companion.userWithFds(str, list);
    }

    public final void addImage(String image) {
        g.f(image, "image");
        if (this.images == null) {
            this.images = new ArrayList();
        }
        List<String> list = this.images;
        g.c(list);
        list.add(image);
    }

    public final int component1() {
        return this.role;
    }

    public final String component2() {
        return this.content;
    }

    public final List<String> component3() {
        return this.images;
    }

    public final List<ParcelFileDescriptor> component4() {
        return this.imageFds;
    }

    public final List<Bitmap> component5() {
        return this.imageBitmaps;
    }

    public final List<LlmToolCall> component6() {
        return this.toolCalls;
    }

    public final String component7() {
        return this.toolCallId;
    }

    public final LlmChatMessage copy(int i10, String str, List<String> list, List<? extends ParcelFileDescriptor> list2, List<Bitmap> list3, List<LlmToolCall> list4, String str2) {
        return new LlmChatMessage(i10, str, list, list2, list3, list4, str2);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LlmChatMessage)) {
            return false;
        }
        LlmChatMessage llmChatMessage = (LlmChatMessage) obj;
        return this.role == llmChatMessage.role && g.b(this.content, llmChatMessage.content) && g.b(this.images, llmChatMessage.images) && g.b(this.imageFds, llmChatMessage.imageFds) && g.b(this.imageBitmaps, llmChatMessage.imageBitmaps) && g.b(this.toolCalls, llmChatMessage.toolCalls) && g.b(this.toolCallId, llmChatMessage.toolCallId);
    }

    public final String getContent() {
        return this.content;
    }

    public final List<Bitmap> getImageBitmaps() {
        return this.imageBitmaps;
    }

    public final List<ParcelFileDescriptor> getImageFds() {
        return this.imageFds;
    }

    public final List<String> getImages() {
        return this.images;
    }

    public final int getRole() {
        return this.role;
    }

    public final String getText() {
        return this.content;
    }

    public final String getToolCallId() {
        return this.toolCallId;
    }

    public final List<LlmToolCall> getToolCalls() {
        return this.toolCalls;
    }

    public int hashCode() {
        int iHashCode = Integer.hashCode(this.role) * 31;
        String str = this.content;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        List<String> list = this.images;
        int iHashCode3 = (iHashCode2 + (list == null ? 0 : list.hashCode())) * 31;
        List<ParcelFileDescriptor> list2 = this.imageFds;
        int iHashCode4 = (iHashCode3 + (list2 == null ? 0 : list2.hashCode())) * 31;
        List<Bitmap> list3 = this.imageBitmaps;
        int iHashCode5 = (iHashCode4 + (list3 == null ? 0 : list3.hashCode())) * 31;
        List<LlmToolCall> list4 = this.toolCalls;
        int iHashCode6 = (iHashCode5 + (list4 == null ? 0 : list4.hashCode())) * 31;
        String str2 = this.toolCallId;
        return iHashCode6 + (str2 != null ? str2.hashCode() : 0);
    }

    public final void setImages(List<String> list) {
        this.images = list;
    }

    public String toString() {
        int i10 = this.role;
        String str = this.content;
        List<String> list = this.images;
        List<ParcelFileDescriptor> list2 = this.imageFds;
        List<Bitmap> list3 = this.imageBitmaps;
        List<LlmToolCall> list4 = this.toolCalls;
        String str2 = this.toolCallId;
        StringBuilder sbE = h0.e.e("LlmChatMessage(role=", i10, ", content=", str, ", images=");
        sbE.append(list);
        sbE.append(", imageFds=");
        sbE.append(list2);
        sbE.append(", imageBitmaps=");
        sbE.append(list3);
        sbE.append(", toolCalls=");
        sbE.append(list4);
        sbE.append(", toolCallId=");
        return ai.onnxruntime.a.o(sbE, str2, ")");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int i10) {
        g.f(dest, "dest");
        dest.writeInt(this.role);
        dest.writeString(this.content);
        dest.writeStringList(this.images);
        List<ParcelFileDescriptor> list = this.imageFds;
        if (list == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(list.size());
            Iterator<ParcelFileDescriptor> it = list.iterator();
            while (it.hasNext()) {
                dest.writeParcelable(it.next(), i10);
            }
        }
        List<Bitmap> list2 = this.imageBitmaps;
        if (list2 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(list2.size());
            Iterator<Bitmap> it2 = list2.iterator();
            while (it2.hasNext()) {
                dest.writeParcelable(it2.next(), i10);
            }
        }
        List<LlmToolCall> list3 = this.toolCalls;
        if (list3 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(list3.size());
            Iterator<LlmToolCall> it3 = list3.iterator();
            while (it3.hasNext()) {
                it3.next().writeToParcel(dest, i10);
            }
        }
        dest.writeString(this.toolCallId);
    }

    public static final LlmChatMessage assistant(List<LlmToolCall> list) {
        return Companion.assistant(list);
    }

    public static final LlmChatMessage user(String str, List<String> list) {
        return Companion.user(str, list);
    }

    public /* synthetic */ LlmChatMessage(int i10, String str, List list, List list2, List list3, List list4, String str2, int i11, e eVar) {
        this(i10, (i11 & 2) != 0 ? null : str, (i11 & 4) != 0 ? null : list, (i11 & 8) != 0 ? null : list2, (i11 & 16) != 0 ? null : list3, (i11 & 32) != 0 ? null : list4, (i11 & 64) != 0 ? null : str2);
    }
}
