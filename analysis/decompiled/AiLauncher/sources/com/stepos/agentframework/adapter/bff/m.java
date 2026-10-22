package com.stepos.agentframework.adapter.bff;

import La.C;
import La.D;
import La.H;
import com.autonavi.aps.amapapi.config.Const;
import com.zyql.protobuf.common.FileData;
import com.zyql.protobuf.common.Part;
import com.zyql.protobuf.skull.Message;
import com.zyql.protobuf.skull.Resource;
import h8.C4148a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.AbstractC0913i;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a\u001b\u0010\u0004\u001a\u0004\u0018\u00010\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a%\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006*\b\u0012\u0004\u0012\u00020\u00000\u00062\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\b\u0010\t\u001a\u0013\u0010\n\u001a\u0004\u0018\u00010\u0000*\u00020\u0007¢\u0006\u0004\b\n\u0010\u000b\u001a\u0011\u0010\r\u001a\u00020\u0000*\u00020\f¢\u0006\u0004\b\r\u0010\u000e\u001a%\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0006*\b\u0012\u0004\u0012\u00020\u00000\u00062\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u0014*\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u0017\u0010\u0019\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"LK6/i;", "Lcom/zyql/protobuf/skull/Message$Builder;", "msgBuilder", "Lcom/zyql/protobuf/skull/Resource$Builder;", "f", "(LK6/i;Lcom/zyql/protobuf/skull/Message$Builder;)Lcom/zyql/protobuf/skull/Resource$Builder;", "", "Lcom/zyql/protobuf/skull/Resource;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/util/List;Lcom/zyql/protobuf/skull/Message$Builder;)Ljava/util/List;", "c", "(Lcom/zyql/protobuf/skull/Resource;)LK6/i;", "Lcom/zyql/protobuf/common/FileData;", Const.INTENT_KEY_PKGNAME, "(Lcom/zyql/protobuf/common/FileData;)LK6/i;", "", "thought", "Lcom/zyql/protobuf/common/Part;", "e", "(Ljava/util/List;Z)Ljava/util/List;", "Lcom/zyql/protobuf/common/Part$Builder;", Const.INTENT_KEY_UMID, "(LK6/i;Z)Lcom/zyql/protobuf/common/Part$Builder;", "", "displayName", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)Ljava/lang/String;", "protocol_bff_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class m {
    public static final String a(String str) {
        return (str == null || str.length() == 0 || H.x0(str)) ? "" : str;
    }

    public static final AbstractC0913i b(FileData fileData) {
        kotlin.jvm.internal.p.i(fileData, "<this>");
        String mimeType = fileData.getMimeType();
        kotlin.jvm.internal.p.h(mimeType, "getMimeType(...)");
        if (D.X(mimeType, "image/", false, 2, null)) {
            return new AbstractC0913i.Image(null, fileData.getUri(), null, null, fileData.getMimeType(), null, null, 109, null);
        }
        String mimeType2 = fileData.getMimeType();
        kotlin.jvm.internal.p.h(mimeType2, "getMimeType(...)");
        if (D.X(mimeType2, "audio/", false, 2, null)) {
            return new AbstractC0913i.Audio(null, fileData.getUri(), fileData.getMimeType(), null, 9, null);
        }
        String mimeType3 = fileData.getMimeType();
        kotlin.jvm.internal.p.h(mimeType3, "getMimeType(...)");
        return D.X(mimeType3, "video/", false, 2, null) ? new AbstractC0913i.Video(null, fileData.getUri(), null, fileData.getMimeType(), null, 21, null) : new AbstractC0913i.File(null, fileData.getUri(), null, null, null, fileData.getMimeType(), null, 93, null);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static final AbstractC0913i c(Resource resource) {
        String mimeType;
        kotlin.jvm.internal.p.i(resource, "<this>");
        String type = resource.getType();
        kotlin.jvm.internal.p.h(type, "getType(...)");
        String lowerCase = type.toLowerCase(Locale.ROOT);
        kotlin.jvm.internal.p.h(lowerCase, "toLowerCase(...)");
        switch (lowerCase.hashCode()) {
            case 3143036:
                if (lowerCase.equals(Const.STR_FILE)) {
                    if (resource.getExtraMap().containsKey("coverUrl") || ((mimeType = resource.getMimeType()) != null && D.X(mimeType, "video/", false, 2, null))) {
                        return new AbstractC0913i.Video(null, resource.getUri(), resource.getExtraMap().get("coverUrl"), resource.getMimeType(), null, 17, null).a(resource.getExtraMap());
                    }
                    String uri = resource.getUri();
                    String mimeType2 = resource.getMimeType();
                    String str = resource.getExtraMap().get("fileName");
                    String str2 = resource.getExtraMap().get("fileSize");
                    return new AbstractC0913i.File(null, uri, null, str, str2 != null ? C.y(str2) : null, mimeType2, null, 69, null).a(resource.getExtraMap());
                }
                return null;
            case 3556653:
                if (lowerCase.equals("text")) {
                    String content = resource.getContent();
                    if (content == null) {
                        content = "";
                    }
                    return new AbstractC0913i.Text(content);
                }
                return null;
            case 93166550:
                if (lowerCase.equals("audio")) {
                    return new AbstractC0913i.Audio(null, resource.getUri(), resource.getMimeType(), null, 9, null).a(resource.getExtraMap());
                }
                return null;
            case 100313435:
                if (lowerCase.equals("image")) {
                    return new AbstractC0913i.Image(null, resource.getUri(), null, resource.getExtraMap().get("thumbnailUrl"), resource.getMimeType(), null, null, 101, null).a(resource.getExtraMap());
                }
                return null;
            default:
                return null;
        }
    }

    public static final Part.Builder d(AbstractC0913i abstractC0913i, boolean z10) {
        kotlin.jvm.internal.p.i(abstractC0913i, "<this>");
        Part.Builder builderNewBuilder = Part.newBuilder();
        builderNewBuilder.setThought(z10);
        abstractC0913i.c();
        if (abstractC0913i instanceof AbstractC0913i.Text) {
            builderNewBuilder.setText(((AbstractC0913i.Text) abstractC0913i).getText());
            return builderNewBuilder;
        }
        if (abstractC0913i instanceof AbstractC0913i.Image) {
            FileData.Builder builderNewBuilder2 = FileData.newBuilder();
            AbstractC0913i.Image image = (AbstractC0913i.Image) abstractC0913i;
            String uri = image.getUri();
            if (uri == null && (uri = image.getBase64()) == null) {
                uri = "";
            }
            builderNewBuilder2.setUri(uri);
            String mimeType = image.getMimeType();
            if (mimeType != null) {
                builderNewBuilder2.setMimeType(mimeType);
            }
            image.getThumbnailUrl();
            builderNewBuilder2.setDisplayName(a(image.getDisplayName()));
            builderNewBuilder.setFileData(builderNewBuilder2.build());
            return builderNewBuilder;
        }
        if (abstractC0913i instanceof AbstractC0913i.Audio) {
            FileData.Builder builderNewBuilder3 = FileData.newBuilder();
            AbstractC0913i.Audio audio = (AbstractC0913i.Audio) abstractC0913i;
            String uri2 = audio.getUri();
            if (uri2 != null) {
                builderNewBuilder3.setUri(uri2);
            }
            String mimeType2 = audio.getMimeType();
            if (mimeType2 != null) {
                builderNewBuilder3.setMimeType(mimeType2);
            }
            builderNewBuilder3.setDisplayName(a(audio.getDisplayName()));
            builderNewBuilder.setFileData(builderNewBuilder3.build());
            return builderNewBuilder;
        }
        if (abstractC0913i instanceof AbstractC0913i.Video) {
            FileData.Builder builderNewBuilder4 = FileData.newBuilder();
            AbstractC0913i.Video video = (AbstractC0913i.Video) abstractC0913i;
            String uri3 = video.getUri();
            if (uri3 != null) {
                builderNewBuilder4.setUri(uri3);
            }
            String mimeType3 = video.getMimeType();
            if (mimeType3 != null) {
                builderNewBuilder4.setMimeType(mimeType3);
            }
            video.getCoverUrl();
            builderNewBuilder4.setDisplayName(a(video.getDisplayName()));
            builderNewBuilder.setFileData(builderNewBuilder4.build());
            return builderNewBuilder;
        }
        if (!(abstractC0913i instanceof AbstractC0913i.File)) {
            return null;
        }
        FileData.Builder builderNewBuilder5 = FileData.newBuilder();
        AbstractC0913i.File file = (AbstractC0913i.File) abstractC0913i;
        String uri4 = file.getUri();
        if (uri4 != null) {
            builderNewBuilder5.setUri(uri4);
        }
        String mimeType4 = file.getMimeType();
        if (mimeType4 != null) {
            builderNewBuilder5.setMimeType(mimeType4);
        }
        file.getFileName();
        file.getFileSize();
        builderNewBuilder5.setDisplayName(a(file.getDisplayName()));
        builderNewBuilder.setFileData(builderNewBuilder5.build());
        return builderNewBuilder;
    }

    public static final List<Part> e(List<? extends AbstractC0913i> list, boolean z10) {
        kotlin.jvm.internal.p.i(list, "<this>");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            Part.Builder builderD = d((AbstractC0913i) it.next(), z10);
            Part partBuild = builderD != null ? builderD.build() : null;
            if (partBuild != null) {
                arrayList.add(partBuild);
            }
        }
        return arrayList;
    }

    public static final Resource.Builder f(AbstractC0913i abstractC0913i, Message.Builder msgBuilder) {
        kotlin.jvm.internal.p.i(abstractC0913i, "<this>");
        kotlin.jvm.internal.p.i(msgBuilder, "msgBuilder");
        Resource.Builder builderNewBuilder = Resource.newBuilder();
        String lowerCase = abstractC0913i.getContentType().name().toLowerCase(Locale.ROOT);
        kotlin.jvm.internal.p.h(lowerCase, "toLowerCase(...)");
        Resource.Builder type = builderNewBuilder.setType(lowerCase);
        type.putAllExtra(abstractC0913i.c());
        if (abstractC0913i instanceof AbstractC0913i.Text) {
            msgBuilder.setContent(((AbstractC0913i.Text) abstractC0913i).getText());
            return null;
        }
        if (abstractC0913i instanceof AbstractC0913i.Image) {
            C4148a.k("ChatContentExt", "toResourceBuilder Image", false, 4, null);
            AbstractC0913i.Image image = (AbstractC0913i.Image) abstractC0913i;
            String uri = image.getUri();
            if (uri == null && (uri = image.getUrl()) == null && (uri = image.getBase64()) == null) {
                uri = "";
            }
            type.setUri(uri);
            String mimeType = image.getMimeType();
            if (mimeType != null) {
                type.setMimeType(mimeType);
            }
            String thumbnailUrl = image.getThumbnailUrl();
            if (thumbnailUrl != null) {
                type.putExtra("thumbnailUrl", thumbnailUrl);
            }
            return type;
        }
        if (abstractC0913i instanceof AbstractC0913i.Audio) {
            AbstractC0913i.Audio audio = (AbstractC0913i.Audio) abstractC0913i;
            type.setUri(audio.getUri());
            String mimeType2 = audio.getMimeType();
            if (mimeType2 != null) {
                type.setMimeType(mimeType2);
            }
            return type;
        }
        if (abstractC0913i instanceof AbstractC0913i.Video) {
            AbstractC0913i.Video video = (AbstractC0913i.Video) abstractC0913i;
            String uri2 = video.getUri();
            if (uri2 != null) {
                type.setUri(uri2);
            }
            String mimeType3 = video.getMimeType();
            if (mimeType3 != null) {
                type.setMimeType(mimeType3);
            }
            String coverUrl = video.getCoverUrl();
            if (coverUrl != null) {
                type.putExtra("coverUrl", coverUrl);
            }
            type.setType(Const.STR_FILE);
            return type;
        }
        if (!(abstractC0913i instanceof AbstractC0913i.File)) {
            return null;
        }
        AbstractC0913i.File file = (AbstractC0913i.File) abstractC0913i;
        String url = file.getUrl();
        if (url != null) {
            type.setUri(url);
        }
        String mimeType4 = file.getMimeType();
        if (mimeType4 != null) {
            type.setMimeType(mimeType4);
        }
        String fileName = file.getFileName();
        if (fileName != null) {
            type.putExtra("fileName", fileName);
        }
        Long fileSize = file.getFileSize();
        if (fileSize != null) {
            type.putExtra("fileSize", String.valueOf(fileSize.longValue()));
        }
        return type;
    }

    public static final List<Resource> g(List<? extends AbstractC0913i> list, Message.Builder msgBuilder) {
        kotlin.jvm.internal.p.i(list, "<this>");
        kotlin.jvm.internal.p.i(msgBuilder, "msgBuilder");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            Resource.Builder builderF = f((AbstractC0913i) it.next(), msgBuilder);
            Resource resourceBuild = builderF != null ? builderF.build() : null;
            if (resourceBuild != null) {
                arrayList.add(resourceBuild);
            }
        }
        return arrayList;
    }
}
