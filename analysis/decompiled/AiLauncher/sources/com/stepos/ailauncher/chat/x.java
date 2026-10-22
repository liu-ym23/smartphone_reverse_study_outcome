package com.stepos.ailauncher.chat;

import Z8.C1168p;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import androidx.activity.result.ActivityResult;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.sheet.T;
import e.AbstractC3969a;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import v9.C5685n;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001b2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\u000f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u001a\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/stepos/ailauncher/chat/x;", "Le/a;", "Lcom/stepos/ailauncher/chat/d;", "Landroidx/activity/result/ActivityResult;", "<init>", "()V", "Landroid/content/Context;", "context", "input", "Landroid/content/Intent;", Const.INTENT_KEY_UMID, "(Landroid/content/Context;Lcom/stepos/ailauncher/chat/d;)Landroid/content/Intent;", "", "resultCode", "intent", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(ILandroid/content/Intent;)Landroidx/activity/result/ActivityResult;", "maxCount", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(I)Landroid/content/Intent;", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Landroid/content/Intent;", "Landroid/net/Uri;", "uri", "e", "(Landroid/net/Uri;)Landroid/content/Intent;", "f", "Companion", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class x extends AbstractC3969a<PickFileArgs, ActivityResult> {
    private static final String GALLERY_PKG = "com.stepos.media.gallery";

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class b {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PickFileType.values().length];
            try {
                iArr[PickFileType.TYPE_IMAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PickFileType.TYPE_DOC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PickFileType.TYPE_ERASER_IMAGE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PickFileType.TYPE_AI_EXPAND_IMAGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // e.AbstractC3969a
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public Intent a(Context context, PickFileArgs input) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(input, "input");
        Uri uri = input.getUri();
        int i10 = b.$EnumSwitchMapping$0[input.getType().ordinal()];
        if (i10 == 1) {
            return h(input.getMaxImageCount());
        }
        if (i10 == 2) {
            return g();
        }
        if (i10 == 3) {
            if (uri != null) {
                return f(uri);
            }
            throw new IllegalArgumentException("When use TYPE_ERASER_IMAGE, uri must not be null!");
        }
        if (i10 != 4) {
            throw new NoWhenBranchMatchedException();
        }
        if (uri != null) {
            return e(uri);
        }
        throw new IllegalArgumentException("When use TYPE_AI_EXPAND_IMAGE, uri must not be null!");
    }

    public final Intent e(Uri uri) {
        Intent intent = new Intent("android.intent.action.EDIT");
        intent.setPackage("com.stepos.media.gallery");
        intent.setDataAndType(uri, "image/*");
        intent.putExtra("enterType", 3);
        w.a(intent);
        return intent;
    }

    public final Intent f(Uri uri) {
        Intent intent = new Intent("android.intent.action.EDIT");
        intent.setPackage("com.stepos.media.gallery");
        intent.setDataAndType(uri, "image/*");
        intent.putExtra("enterType", 2);
        w.a(intent);
        return intent;
    }

    public final Intent g() {
        Intent intent = new Intent("android.intent.action.GET_CONTENT", (Uri) null);
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setPackage(T.PKG_DOCUMENTS_UI);
        intent.setType("*/*");
        w.a(intent);
        intent.putExtra("android.intent.extra.MIME_TYPES", (String[]) C1168p.G(q.SUPPORTED_MIME_TYPES, new String[]{"text/*", "application/octet-stream"}));
        return intent;
    }

    public final Intent h(int maxCount) {
        int iN = C5685n.n(maxCount, 1, 10);
        Intent intent = new Intent("android.intent.action.PICK", (Uri) null);
        intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
        intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
        intent.putExtra("filesLimit", iN);
        w.a(intent);
        return intent;
    }

    @Override // e.AbstractC3969a
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public ActivityResult c(int resultCode, Intent intent) {
        return new ActivityResult(resultCode, intent);
    }
}
