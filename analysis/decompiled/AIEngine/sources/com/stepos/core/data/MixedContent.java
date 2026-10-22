package com.stepos.core.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.stepos.core.data.base.Content;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.a;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.i;
import mb.l;
import mb.m;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class MixedContent extends Content {
    private final List<Content> contents;
    public static final Companion Companion = new Companion(null);
    public static final Parcelable.Creator<MixedContent> CREATOR = new Parcelable.Creator<MixedContent>() { // from class: com.stepos.core.data.MixedContent$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MixedContent createFromParcel(Parcel parcel) {
            g.f(parcel, "parcel");
            parcel.readInt();
            ContentParams contentParamsCreateFromParcel = parcel.readByte() == 1 ? ContentParams.CREATOR.createFromParcel(parcel) : null;
            MixedContent mixedContent = new MixedContent(parcel);
            ((Content) mixedContent).params = contentParamsCreateFromParcel;
            return mixedContent;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MixedContent[] newArray(int i10) {
            return new MixedContent[i10];
        }
    };

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final MixedContent readFieldsFromParcel(Parcel parcel) {
            g.f(parcel, "parcel");
            return new MixedContent(parcel);
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public MixedContent(List<? extends Content> contents) {
        super(5);
        g.f(contents, "contents");
        this.contents = contents;
    }

    public static final MixedContent readFieldsFromParcel(Parcel parcel) {
        return Companion.readFieldsFromParcel(parcel);
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
        return (FileContent) a.v0(arrayList);
    }

    public final ImageContent getImage() {
        List<Content> list = this.contents;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (obj instanceof ImageContent) {
                arrayList.add(obj);
            }
        }
        return (ImageContent) a.v0(arrayList);
    }

    public final TextContent getText() {
        List<Content> list = this.contents;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (obj instanceof TextContent) {
                arrayList.add(obj);
            }
        }
        return (TextContent) a.v0(arrayList);
    }

    public String toString() {
        List<Content> list = this.contents;
        ArrayList arrayList = new ArrayList(m.Z(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(i.a(((Content) it.next()).getClass()).c());
        }
        return "MixedContent(contents=" + arrayList + ")";
    }

    public final boolean validate() {
        return !this.contents.isEmpty();
    }

    @Override // com.stepos.core.data.base.Content, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        g.f(parcel, "parcel");
        super.writeToParcel(parcel, i10);
        parcel.writeInt(this.contents.size());
        for (Content content : this.contents) {
            parcel.writeInt(content.getType());
            if (content instanceof TextContent) {
                parcel.writeString(((TextContent) content).getText());
            } else if (content instanceof ImageContent) {
                ImageContent imageContent = (ImageContent) content;
                parcel.writeTypedObject(imageContent.getHwBuffer(), i10);
                parcel.writeTypedObject(imageContent.getShmFd(), i10);
                parcel.writeLong(imageContent.getShmSize());
                parcel.writeInt(imageContent.getWidth());
                parcel.writeInt(imageContent.getHeight());
                parcel.writeInt(imageContent.getFormat());
                parcel.writeInt(imageContent.getRotation());
                parcel.writeTypedObject(imageContent.getSharedMemory(), i10);
            } else if (content instanceof AudioContent) {
                AudioContent audioContent = (AudioContent) content;
                parcel.writeByteArray(audioContent.getAudioBytes());
                parcel.writeInt(audioContent.getSampleRate());
                parcel.writeInt(audioContent.getChannelCount());
            } else if (content instanceof VideoContent) {
                VideoContent videoContent = (VideoContent) content;
                parcel.writeTypedObject(videoContent.getHwBuffer(), i10);
                parcel.writeTypedObject(videoContent.getShmFd(), i10);
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
                parcel.writeTypedObject(fileContent.getPfd(), i10);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MixedContent(String text, String imagePath) {
        this((List<? extends Content>) m.b0(new TextContent(text), new FileContent(imagePath, null, null, 6, null)));
        g.f(text, "text");
        g.f(imagePath, "imagePath");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MixedContent(Content... contents) {
        this((List<? extends Content>) l.q0(contents));
        g.f(contents, "contents");
    }

    public MixedContent(Parcel parcel) {
        Parcelable textContent;
        g.f(parcel, "parcel");
        ArrayList arrayList = new ArrayList();
        int i10 = parcel.readInt();
        for (int i11 = 0; i11 < i10; i11++) {
            int i12 = parcel.readInt();
            if (i12 == 0) {
                textContent = new TextContent(parcel);
            } else if (i12 == 1) {
                textContent = new ImageContent(parcel);
            } else if (i12 == 2) {
                textContent = new VideoContent(parcel);
            } else if (i12 == 3) {
                textContent = new AudioContent(parcel);
            } else if (i12 == 4) {
                textContent = new FileContent(parcel);
            } else {
                throw new IllegalArgumentException(ai.onnxruntime.providers.a.a(i12, "Unknown content type: "));
            }
            arrayList.add(textContent);
        }
        this(arrayList);
    }
}
