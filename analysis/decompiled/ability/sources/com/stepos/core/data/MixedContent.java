package com.stepos.core.data;

import B7.a;
import D7.q;
import D7.v;
import D7.w;
import H4.o;
import L.g;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RequiresApi;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.core.data.base.Content;
import d5.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.m;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 '2\u00020\u0001:\u0001(B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\u0004\u0010\tB\u001d\b\u0016\u0012\u0012\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\n\"\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u000bB\u0011\b\u0011\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u0004\u0010\u000eJ\u001f\u0010\u0012\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0017¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001a\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001d\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010 \u001a\u0004\u0018\u00010\u001f¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\"\u0010#R\u001d\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010$\u001a\u0004\b%\u0010&¨\u0006)"}, d2 = {"Lcom/stepos/core/data/MixedContent;", "Lcom/stepos/core/data/base/Content;", "", "contents", AppAgent.CONSTRUCT, "(Ljava/util/List;)V", "", "text", "imagePath", "(Ljava/lang/String;Ljava/lang/String;)V", "", "([Lcom/stepos/core/data/base/Content;)V", "Landroid/os/Parcel;", "parcel", "(Landroid/os/Parcel;)V", "", "flags", "LC7/r;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", "validate", "()Z", "Lcom/stepos/core/data/TextContent;", "getText", "()Lcom/stepos/core/data/TextContent;", "Lcom/stepos/core/data/ImageContent;", "getImage", "()Lcom/stepos/core/data/ImageContent;", "Lcom/stepos/core/data/FileContent;", "getFile", "()Lcom/stepos/core/data/FileContent;", "toString", "()Ljava/lang/String;", "Ljava/util/List;", "getContents", "()Ljava/util/List;", "Companion", "d5/r", "shared-lib_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class MixedContent extends Content {
    private final List<Content> contents;
    public static final r Companion = new r();
    public static final Parcelable.Creator<MixedContent> CREATOR = new g(17);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public MixedContent(List<? extends Content> contents) {
        super(5);
        k.f(contents, "contents");
        this.contents = contents;
    }

    @RequiresApi(26)
    public static final MixedContent readFieldsFromParcel(Parcel parcel) {
        Companion.getClass();
        k.f(parcel, "parcel");
        return new MixedContent(parcel);
    }

    @Override // com.stepos.core.data.base.Content, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final List<Content> getContents() {
        return this.contents;
    }

    public final FileContent getFile() {
        List<Content> list = this.contents;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (obj instanceof FileContent) {
                arrayList.add(obj);
            }
        }
        return (FileContent) v.C0(arrayList);
    }

    public final ImageContent getImage() {
        List<Content> list = this.contents;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (obj instanceof ImageContent) {
                arrayList.add(obj);
            }
        }
        return (ImageContent) v.C0(arrayList);
    }

    public final TextContent getText() {
        List<Content> list = this.contents;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (obj instanceof TextContent) {
                arrayList.add(obj);
            }
        }
        return (TextContent) v.C0(arrayList);
    }

    public String toString() {
        List<Content> list = this.contents;
        ArrayList arrayList = new ArrayList(w.c0(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(m.f4928a.b(((Content) it.next()).getClass()).m());
        }
        return "MixedContent(contents=" + arrayList + ")";
    }

    public final boolean validate() {
        return !this.contents.isEmpty();
    }

    @Override // com.stepos.core.data.base.Content, android.os.Parcelable
    @RequiresApi(26)
    public void writeToParcel(Parcel parcel, int flags) {
        k.f(parcel, "parcel");
        super.writeToParcel(parcel, flags);
        parcel.writeInt(this.contents.size());
        for (Content content : this.contents) {
            parcel.writeInt(content.getType());
            if (content instanceof TextContent) {
                parcel.writeString(((TextContent) content).getText());
            } else if (content instanceof ImageContent) {
                ImageContent imageContent = (ImageContent) content;
                parcel.writeTypedObject(imageContent.getHwBuffer(), flags);
                parcel.writeTypedObject(imageContent.getShmFd(), flags);
                parcel.writeLong(imageContent.getShmSize());
                parcel.writeInt(imageContent.getWidth());
                parcel.writeInt(imageContent.getHeight());
                parcel.writeInt(imageContent.getFormat());
                parcel.writeInt(imageContent.getRotation());
                parcel.writeTypedObject(imageContent.getSharedMemory(), flags);
            } else if (content instanceof AudioContent) {
                AudioContent audioContent = (AudioContent) content;
                parcel.writeByteArray(audioContent.getAudioBytes());
                parcel.writeInt(audioContent.getSampleRate());
                parcel.writeInt(audioContent.getChannelCount());
            } else if (content instanceof VideoContent) {
                VideoContent videoContent = (VideoContent) content;
                parcel.writeTypedObject(videoContent.getHwBuffer(), flags);
                parcel.writeTypedObject(videoContent.getShmFd(), flags);
                parcel.writeLong(videoContent.getShmSize());
                parcel.writeInt(videoContent.getWidth());
                parcel.writeInt(videoContent.getHeight());
                parcel.writeInt(videoContent.getFormat());
                parcel.writeLong(videoContent.getDuration());
                parcel.writeInt(videoContent.getFrameRate());
            } else if (content instanceof FileContent) {
                FileContent fileContent = (FileContent) content;
                parcel.writeString(fileContent.getPath());
                parcel.writeString(fileContent.getMimeType());
                parcel.writeTypedObject(fileContent.getPfd(), flags);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MixedContent(String text, String imagePath) {
        this((List<? extends Content>) o.N(new TextContent(text), new FileContent(imagePath, null, null, 6, null)));
        k.f(text, "text");
        k.f(imagePath, "imagePath");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MixedContent(Content... contents) {
        this((List<? extends Content>) q.I0(contents));
        k.f(contents, "contents");
    }

    @RequiresApi(26)
    public MixedContent(Parcel parcel) {
        Parcelable textContent;
        k.f(parcel, "parcel");
        ArrayList arrayList = new ArrayList();
        int i = parcel.readInt();
        for (int i6 = 0; i6 < i; i6++) {
            int i10 = parcel.readInt();
            if (i10 == 0) {
                textContent = new TextContent(parcel);
            } else if (i10 == 1) {
                textContent = new ImageContent(parcel);
            } else if (i10 == 2) {
                textContent = new VideoContent(parcel);
            } else if (i10 == 3) {
                textContent = new AudioContent(parcel);
            } else if (i10 == 4) {
                textContent = new FileContent(parcel);
            } else {
                throw new IllegalArgumentException(a.h(i10, "Unknown content type: "));
            }
            arrayList.add(textContent);
        }
        this(arrayList);
    }
}
