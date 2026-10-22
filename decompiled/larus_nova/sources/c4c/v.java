package c4c;

import com.bytedance.lark.pb.basic.v1.ThemeColor;
import com.bytedance.lark.pb.search.v2.URLMeta;
import com.ss.android.lark.export.entity.preview.UDIcon;
import com.ss.android.lark.search.dto.info.SearchLinkInfo;

/* JADX INFO: loaded from: classes38.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f22443a = 0;

    public static final class a {
        public static SearchLinkInfo a(URLMeta r110) {
            UDIcon r100 = null;
            Integer r101 = null;
            if (r110 == null) goto L28;
            SearchLinkInfo r102 = new SearchLinkInfo();
            r102.setOriginalUrl(r110.url);
            r102.setImageUrl(r110.icon_url);
            r102.setCreateTime(r110.create_time.longValue());
            r102.setChatId(r110.chat_id);
            r102.setThreadId(r110.thread_id);
            r102.setPosition(r110.message_position.intValue());
            r102.setThreadPosition(r110.thread_position.intValue());
            int r103 = v.f22443a;
            com.bytedance.lark.pb.basic.v1.UDIcon r104 = r110.ud_icon;
            if (r104 == null) goto L26;
            String r105 = r104.key;
            ThemeColor r106 = r104.color;
            if (r106 != null) goto L10;
            com.ss.android.lark.export.entity.preview.ThemeColor r107 = null;
        L25:
            r100 = new UDIcon(r105, r107, null, 4, null);
            goto L26
        L10:
            ThemeColor.Key r108 = r106.key;
            String r109 = r106.token;
            Integer r111 = r106.value;
            com.ss.android.lark.export.entity.preview.ThemeColor.KeyType.a r112 = com.ss.android.lark.export.entity.preview.ThemeColor.KeyType.Companion;
            if (r108 == null) goto L15;
            ThemeColor.KeyType r113 = r108.type;
            if (r113 == null) goto L15;
            Integer r114 = Integer.valueOf(r113.getValue());
        L16:
            r112.getClass();
            com.ss.android.lark.export.entity.preview.ThemeColor.KeyType r115 = com.ss.android.lark.export.entity.preview.ThemeColor.KeyType.a.a(r114);
            if (r108 == null) goto L19;
            r101 = r108.value;
        L19:
            if (r108 == null) goto L23;
            Integer r116 = r108.alpha;
            if (r116 == null) goto L23;
            int r117 = r116.intValue();
        L24:
            r107 = new com.ss.android.lark.export.entity.preview.ThemeColor(r109, r111, new com.ss.android.lark.export.entity.preview.ThemeColor.Key(r115, r101, r117));
        L23:
            r117 = 100;
        L15:
            r114 = null;
        L26:
            r102.setUDIcon(r100);
            r102.setImageSet(r110.image_icon);
            r102.setPreviewToken(r110.preview_token);
            return r102;
        L28:
            return null;
        }
    }

    static {
    }

    public v() {
    }
}
