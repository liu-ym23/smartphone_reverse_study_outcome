package com.stepos.core.data;

import D7.v;
import L.g;
import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.compose.material3.MenuKt;
import androidx.constraintlayout.core.dsl.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.commoninternal.Key;
import d5.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\b\u0087\b\u0018\u0000 =2\u00020\u0001:\u0001>Bo\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\b\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0004¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\r\u0010\u001b\u001a\u00020\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u001cJ\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ\u0018\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b \u0010!J\u0018\u0010\"\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\"\u0010!J\u0018\u0010#\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b#\u0010!J\u0018\u0010$\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b$\u0010!J\u0012\u0010%\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b%\u0010\u001fJz\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\b2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0004\b&\u0010'J\u0010\u0010(\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b(\u0010\u001fJ\u0010\u0010)\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b)\u0010\u001cJ\u001a\u0010-\u001a\u00020,2\b\u0010+\u001a\u0004\u0018\u00010*HÖ\u0003¢\u0006\u0004\b-\u0010.R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010/\u001a\u0004\b0\u0010\u001cR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u00101\u001a\u0004\b2\u0010\u001fR*\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u00103\u001a\u0004\b4\u0010!\"\u0004\b5\u00106R\u001f\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\n\u00103\u001a\u0004\b7\u0010!R\u001f\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\f\u00103\u001a\u0004\b8\u0010!R\u001f\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\u000e\u00103\u001a\u0004\b9\u0010!R\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u000f\u00101\u001a\u0004\b:\u0010\u001fR\u0013\u0010<\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b;\u0010\u001f¨\u0006?"}, d2 = {"Lcom/stepos/core/data/LlmChatMessage;", "Landroid/os/Parcelable;", "", "role", "", "content", "", "images", "", "Landroid/os/ParcelFileDescriptor;", "imageFds", "Landroid/graphics/Bitmap;", "imageBitmaps", "Lcom/stepos/core/data/LlmToolCall;", "toolCalls", Key.KEY_TOOL_CALL_ID, AppAgent.CONSTRUCT, "(ILjava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;)V", "image", "LC7/r;", "addImage", "(Ljava/lang/String;)V", "Landroid/os/Parcel;", "dest", "flags", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "component2", "()Ljava/lang/String;", "component3", "()Ljava/util/List;", "component4", "component5", "component6", "component7", "copy", "(ILjava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;)Lcom/stepos/core/data/LlmChatMessage;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getRole", "Ljava/lang/String;", "getContent", "Ljava/util/List;", "getImages", "setImages", "(Ljava/util/List;)V", "getImageFds", "getImageBitmaps", "getToolCalls", "getToolCallId", "getText", "text", "Companion", "d5/p", "shared-lib_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class LlmChatMessage implements Parcelable {
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
    public static final p Companion = new p();
    public static final Parcelable.Creator<LlmChatMessage> CREATOR = new g(15);

    /* JADX WARN: Multi-variable type inference failed */
    public LlmChatMessage(int i, String str, List<String> list, List<? extends ParcelFileDescriptor> list2, List<Bitmap> list3, List<LlmToolCall> list4, String str2) {
        this.role = i;
        this.content = str;
        this.images = list;
        this.imageFds = list2;
        this.imageBitmaps = list3;
        this.toolCalls = list4;
        this.toolCallId = str2;
    }

    public static final LlmChatMessage aiMessage(String content) {
        Companion.getClass();
        k.f(content, "content");
        return new LlmChatMessage(1, content, null, null, null, null, null, 124, null);
    }

    public static final LlmChatMessage assistant(List<LlmToolCall> toolCalls) {
        Companion.getClass();
        k.f(toolCalls, "toolCalls");
        return new LlmChatMessage(1, null, null, null, null, toolCalls, null, 94, null);
    }

    public static /* synthetic */ LlmChatMessage copy$default(LlmChatMessage llmChatMessage, int i, String str, List list, List list2, List list3, List list4, String str2, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i = llmChatMessage.role;
        }
        if ((i6 & 2) != 0) {
            str = llmChatMessage.content;
        }
        if ((i6 & 4) != 0) {
            list = llmChatMessage.images;
        }
        if ((i6 & 8) != 0) {
            list2 = llmChatMessage.imageFds;
        }
        if ((i6 & 16) != 0) {
            list3 = llmChatMessage.imageBitmaps;
        }
        if ((i6 & 32) != 0) {
            list4 = llmChatMessage.toolCalls;
        }
        if ((i6 & 64) != 0) {
            str2 = llmChatMessage.toolCallId;
        }
        List list5 = list4;
        String str3 = str2;
        List list6 = list3;
        List list7 = list;
        return llmChatMessage.copy(i, str, list7, list2, list6, list5, str3);
    }

    public static final LlmChatMessage system(String content) {
        Companion.getClass();
        k.f(content, "content");
        return new LlmChatMessage(2, content, null, null, null, null, null, 124, null);
    }

    public static final LlmChatMessage systemMessage(String content) {
        Companion.getClass();
        k.f(content, "content");
        return new LlmChatMessage(2, content, null, null, null, null, null, 124, null);
    }

    public static final LlmChatMessage tool(String toolCallId, String content) {
        Companion.getClass();
        k.f(toolCallId, "toolCallId");
        k.f(content, "content");
        return new LlmChatMessage(3, content, null, null, null, null, toolCallId, 60, null);
    }

    public static final LlmChatMessage user(String content, List<String> images) {
        Companion.getClass();
        k.f(content, "content");
        k.f(images, "images");
        return new LlmChatMessage(0, content, v.g1(images), null, null, null, null, MenuKt.InTransitionDuration, null);
    }

    public static final LlmChatMessage userMessage(String content) {
        Companion.getClass();
        k.f(content, "content");
        return new LlmChatMessage(0, content, null, null, null, null, null, 124, null);
    }

    public static final LlmChatMessage userWithBitmaps(String content, List<Bitmap> imageBitmaps) {
        Companion.getClass();
        k.f(content, "content");
        k.f(imageBitmaps, "imageBitmaps");
        return new LlmChatMessage(0, content, null, null, imageBitmaps, null, null, AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, null);
    }

    public static final LlmChatMessage userWithFds(String content, List<? extends ParcelFileDescriptor> imageFds) {
        Companion.getClass();
        k.f(content, "content");
        k.f(imageFds, "imageFds");
        return new LlmChatMessage(0, content, null, imageFds, null, null, null, 116, null);
    }

    public final void addImage(String image) {
        k.f(image, "image");
        if (this.images == null) {
            this.images = new ArrayList();
        }
        List<String> list = this.images;
        k.c(list);
        list.add(image);
    }

    /* renamed from: component1, reason: from getter */
    public final int getRole() {
        return this.role;
    }

    /* renamed from: component2, reason: from getter */
    public final String getContent() {
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

    /* renamed from: component7, reason: from getter */
    public final String getToolCallId() {
        return this.toolCallId;
    }

    public final LlmChatMessage copy(int role, String content, List<String> images, List<? extends ParcelFileDescriptor> imageFds, List<Bitmap> imageBitmaps, List<LlmToolCall> toolCalls, String toolCallId) {
        return new LlmChatMessage(role, content, images, imageFds, imageBitmaps, toolCalls, toolCallId);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LlmChatMessage)) {
            return false;
        }
        LlmChatMessage llmChatMessage = (LlmChatMessage) other;
        return this.role == llmChatMessage.role && k.b(this.content, llmChatMessage.content) && k.b(this.images, llmChatMessage.images) && k.b(this.imageFds, llmChatMessage.imageFds) && k.b(this.imageBitmaps, llmChatMessage.imageBitmaps) && k.b(this.toolCalls, llmChatMessage.toolCalls) && k.b(this.toolCallId, llmChatMessage.toolCallId);
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
        int i = this.role;
        String str = this.content;
        List<String> list = this.images;
        List<ParcelFileDescriptor> list2 = this.imageFds;
        List<Bitmap> list3 = this.imageBitmaps;
        List<LlmToolCall> list4 = this.toolCalls;
        String str2 = this.toolCallId;
        StringBuilder sbK = a.k(i, "LlmChatMessage(role=", ", content=", str, ", images=");
        sbK.append(list);
        sbK.append(", imageFds=");
        sbK.append(list2);
        sbK.append(", imageBitmaps=");
        sbK.append(list3);
        sbK.append(", toolCalls=");
        sbK.append(list4);
        sbK.append(", toolCallId=");
        return B7.a.q(sbK, str2, ")");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        k.f(dest, "dest");
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
                dest.writeParcelable(it.next(), flags);
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
                dest.writeParcelable(it2.next(), flags);
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
                it3.next().writeToParcel(dest, flags);
            }
        }
        dest.writeString(this.toolCallId);
    }

    public static final LlmChatMessage assistant(String content) {
        Companion.getClass();
        k.f(content, "content");
        return new LlmChatMessage(1, content, null, null, null, null, null, 124, null);
    }

    public static final LlmChatMessage user(String content) {
        Companion.getClass();
        k.f(content, "content");
        return new LlmChatMessage(0, content, null, null, null, null, null, 124, null);
    }

    public /* synthetic */ LlmChatMessage(int i, String str, List list, List list2, List list3, List list4, String str2, int i6, e eVar) {
        this(i, (i6 & 2) != 0 ? null : str, (i6 & 4) != 0 ? null : list, (i6 & 8) != 0 ? null : list2, (i6 & 16) != 0 ? null : list3, (i6 & 32) != 0 ? null : list4, (i6 & 64) != 0 ? null : str2);
    }
}
