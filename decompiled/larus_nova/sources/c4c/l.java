package c4c;

import com.bytedance.lark.pb.search.v2.FileContent;
import com.bytedance.lark.pb.search.v2.MessageFileMeta;
import com.ss.android.lark.chat.entity.message.content.FolderContent;
import com.ss.android.lark.search.dto.info.SearchMessageFileInfo;

/* JADX INFO: loaded from: classes38.dex */
public final class l {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f22441a = null;

        static {
            int[] r100 = new int[MessageFileMeta.FileType.values().length];
            r100[MessageFileMeta.FileType.FILE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[MessageFileMeta.FileType.FOLDER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f22441a = r100;
        }
    }

    public l() {
    }

    public static SearchMessageFileInfo a(MessageFileMeta r100) {
        if (r100 == null) goto L22;
        SearchMessageFileInfo r101 = new SearchMessageFileInfo();
        r101.setFileType(r100.file_type);
        r101.setCreateTime(r100.create_time.longValue());
        r101.setUpdateTime(r100.create_time.longValue());
        r101.setMsgId(r100.message_id);
        r101.setPosition(r100.message_position.intValue());
        r101.setChatId(r100.chat_id);
        r101.setFromId(r100.from_id);
        r101.setFromTenantId(r100.from_tenant_id);
        r101.setMessageId(r100.message_id);
        r101.setInnerFile(r100.is_inner_file.booleanValue());
        r101.setThreadId(r100.thread_id);
        r101.setMessageThreadPosition(r100.thread_position.intValue());
        r101.setThreadChatPosition(r100.thread_chat_position.intValue());
        r101.setThreadMessageType(r100.thread_message_type);
        r101.setRootMessagePosition(r100.root_message_position.intValue());
        r101.setDestroyed(r100.is_destroyed.booleanValue());
        r101.setSceneId(Integer.valueOf((int) r100.scene_id.longValue()));
        FileContent r102 = r100.file_meta;
        if (r102 == null) goto L24;
        MessageFileMeta.FileType r103 = r101.getFileType();
        if (r103 != null) goto L8;
        int r104 = -1;
    L10:
        if (r104 != 1) goto L12;
        String r105 = r100.file_path;
        com.ss.android.lark.chat.entity.message.content.FileContent r106 = new com.ss.android.lark.chat.entity.message.content.FileContent();
        r106.setFilePath(r105);
        r106.setKey(r102.key);
        r106.setName(r102.name);
        r106.setMime(r102.mime);
        r106.setSize(r102.size.longValue());
        FileContent.Source r107 = r102.source;
        if (r107 == null) goto L21;
        r106.setSource(r107.getValue());
    L21:
        r101.setFileContent(r106);
        return r101;
    L12:
        if (r104 != 2) goto L27;
        FolderContent r108 = new FolderContent();
        r108.setKey(r102.key);
        r108.setName(r102.name);
        r108.setSize(r102.size.longValue());
        FileContent.Source r109 = r102.source;
        if (r109 == null) goto L17;
        r108.setSource(r109.getValue());
    L17:
        r101.setFolderContent(r108);
        return r101;
    L27:
        return r101;
    L8:
        r104 = a.f22441a[r103.ordinal()];
        goto L10
    L24:
        return r101;
    L22:
        return null;
    }
}
