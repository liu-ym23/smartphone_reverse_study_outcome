package com.stepos.agentframework.file;

import La.H;
import Y8.t;
import Z8.C1173v;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.ContextThemeWrapper;
import android.view.Lifecycle;
import android.webkit.MimeTypeMap;
import androidx.activity.result.ActivityResult;
import androidx.appcompat.app.d;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.file.FileInfo;
import com.stepos.agentframework.chatui.R1;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.zyql.ai.selector.PictureSelector;
import com.zyql.ai.selector.config.PictureMimeType;
import com.zyql.ai.selector.entity.LocalMedia;
import com.zyql.ai.selector.listener.OnResultCallbackListener;
import com.zyql.ai.selector.style.PictureSelectorUIStyle;
import d.AbstractC3936b;
import d.InterfaceC3935a;
import e.e;
import h8.C4148a;
import java.util.List;
import java.util.Locale;
import kotlin.C4849c;
import kotlin.Function2;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u00014B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000f\u001a\u00020\u0006¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001d\u0010\u001eR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001f\u001a\u0004\b \u0010!R\u0014\u0010\"\u001a\u00020\b8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\"\u0010#R\u001e\u0010&\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R$\u0010(\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010\u0018R$\u0010.\u001a\u0004\u0018\u00010-8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103¨\u00065"}, d2 = {"Lcom/stepos/agentframework/file/FileManager;", "", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/net/Uri;", "uri", "", Const.INTENT_KEY_UMID, "(Landroid/content/Context;Landroid/net/Uri;)Ljava/lang/String;", "fileType", "", "k", "(Ljava/lang/String;)I", "sourceUri", "c", "(Landroid/net/Uri;)Ljava/lang/String;", "LY8/t;", Const.INTENT_KEY_BACKGROUND_COMMAND, "()V", "Lcom/stepos/agentframework/file/FileManager$a;", "pickListener", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Lcom/stepos/agentframework/file/FileManager$a;)V", "Landroidx/activity/result/ActivityResult;", "result", "Landroidx/appcompat/app/d;", "activity", "f", "(Landroidx/activity/result/ActivityResult;Landroidx/appcompat/app/d;)V", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "TAG", "Ljava/lang/String;", "Ld/b;", "Landroid/content/Intent;", "pickFileLauncher", "Ld/b;", "filePickListener", "Lcom/stepos/agentframework/file/FileManager$a;", "e", "()Lcom/stepos/agentframework/file/FileManager$a;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "Lcom/stepos/agentframework/file/b;", "pickerProvider", "Lcom/stepos/agentframework/file/b;", "getPickerProvider", "()Lcom/stepos/agentframework/file/b;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Lcom/stepos/agentframework/file/b;)V", Const.INTENT_KEY_APIKEY, "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FileManager {
    private final String TAG;
    private final Context context;
    private a filePickListener;
    private AbstractC3936b<Intent> pickFileLauncher;
    private b pickerProvider;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lcom/stepos/agentframework/file/FileManager$a;", "", "", "Lcom/stepos/agentframework/chatcore/file/FileInfo;", "images", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Ljava/util/List;)V", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface a {
        void a(List<FileInfo> images);
    }

    public FileManager(Context context) {
        Object objB;
        p.i(context, "context");
        this.context = context;
        this.TAG = "FileManager";
        final Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity == null) {
            ContextThemeWrapper contextThemeWrapper = context instanceof ContextThemeWrapper ? (ContextThemeWrapper) context : null;
            Object baseContext = contextThemeWrapper != null ? contextThemeWrapper.getBaseContext() : null;
            activity = baseContext instanceof Activity ? (Activity) baseContext : null;
        }
        if ((activity instanceof d) && C1173v.p(Lifecycle.State.INITIALIZED, Lifecycle.State.STARTED).contains(((d) activity).getLifecycle().getState())) {
            try {
                Result.Companion companion = Result.INSTANCE;
                objB = Result.b(((d) activity).registerForActivityResult(new e(), new InterfaceC3935a() { // from class: com.stepos.agentframework.file.a
                    @Override // d.InterfaceC3935a
                    public final void a(Object obj) {
                        FileManager.a(this.f23242a, activity, (ActivityResult) obj);
                    }
                }));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            this.pickFileLauncher = (AbstractC3936b) (Result.g(objB) ? null : objB);
        }
    }

    public static void a(FileManager fileManager, Activity activity, ActivityResult result) {
        p.i(result, "result");
        fileManager.f(result, (d) activity);
    }

    public final String c(Uri sourceUri) {
        p.i(sourceUri, "sourceUri");
        return c.INSTANCE.a(this.context, sourceUri);
    }

    public final String d(Context context, Uri uri) {
        p.i(context, "context");
        p.i(uri, "uri");
        try {
            String extensionFromMimeType = MimeTypeMap.getSingleton().getExtensionFromMimeType(context.getContentResolver().getType(uri));
            if (extensionFromMimeType != null) {
                return extensionFromMimeType;
            }
            String string = uri.toString();
            p.h(string, "toString(...)");
            String strS1 = H.s1(string, '.', null, 2, null);
            if (strS1.length() > 0) {
                return strS1;
            }
            return null;
        } catch (Exception e10) {
            C4148a.g(this.TAG, "获取文件扩展名失败：" + e10.getMessage(), e10, false, 8, null);
            return null;
        }
    }

    /* renamed from: e, reason: from getter */
    public final a getFilePickListener() {
        return this.filePickListener;
    }

    public final void f(ActivityResult result, d activity) {
        if (result.getResultCode() == -1) {
            Function2.a(new FileManager$handlePickerLauncherResult$1(result, this, activity, null));
        }
    }

    public final void g() throws Throwable {
        t tVar;
        String[] strArr = {"application/pdf", com.stepos.statsapp.v3.lib.plugin.net.multipart.e.f30839B};
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType("*/*");
        intent.putExtra("select_file", true);
        intent.putExtra("android.intent.extra.MIME_TYPES", strArr);
        intent.addFlags(524288);
        AbstractC3936b<Intent> abstractC3936b = this.pickFileLauncher;
        if (abstractC3936b != null) {
            abstractC3936b.a(intent);
            tVar = t.f7040a;
        } else {
            tVar = null;
        }
        if (tVar == null) {
            throw new Throwable("文件选择器初始化异常！！");
        }
    }

    public final void h(final a pickListener) {
        p.i(pickListener, "pickListener");
        Context context = this.context;
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity == null) {
            ContextThemeWrapper contextThemeWrapper = context instanceof ContextThemeWrapper ? (ContextThemeWrapper) context : null;
            Object baseContext = contextThemeWrapper != null ? contextThemeWrapper.getBaseContext() : null;
            Activity activity2 = baseContext instanceof Activity ? (Activity) baseContext : null;
            if (activity2 == null) {
                return;
            } else {
                activity = activity2;
            }
        }
        if (activity instanceof d) {
            PictureSelector.create(activity).openGallery(PictureMimeType.ofImage()).maxSelectNum(10).imageEngine(R1.a()).setPictureUIStyle(PictureSelectorUIStyle.ofDefaultStyle()).forResult(new OnResultCallbackListener<LocalMedia>() { // from class: com.stepos.agentframework.file.FileManager$pickImages$1
                @Override // com.zyql.ai.selector.listener.OnResultCallbackListener
                public void onCancel() {
                }

                @Override // com.zyql.ai.selector.listener.OnResultCallbackListener
                public void onResult(List<LocalMedia> selectedList) {
                    p.i(selectedList, "selectedList");
                    Function2.a(new FileManager$pickImages$1$onResult$1(selectedList, pickListener, null));
                }
            });
        }
    }

    public final void i(a aVar) {
        this.filePickListener = aVar;
    }

    public final void j(b bVar) {
    }

    public final int k(String fileType) {
        String lowerCase;
        if (fileType != null) {
            lowerCase = fileType.toLowerCase(Locale.ROOT);
            p.h(lowerCase, "toLowerCase(...)");
        } else {
            lowerCase = null;
        }
        if (lowerCase == null) {
            return 5;
        }
        switch (lowerCase.hashCode()) {
            case 3479:
                return !lowerCase.equals("md") ? 5 : 11;
            case 96980:
                return !lowerCase.equals("avi") ? 5 : 2;
            case 98822:
                return !lowerCase.equals("csv") ? 5 : 9;
            case 99640:
                return !lowerCase.equals(ChatTracker.CONTENT_DOC) ? 5 : 8;
            case 108184:
                return !lowerCase.equals("mkv") ? 5 : 2;
            case 108273:
                return !lowerCase.equals("mp4") ? 5 : 2;
            case 108308:
                return !lowerCase.equals("mov") ? 5 : 2;
            case 110834:
                return !lowerCase.equals("pdf") ? 5 : 4;
            case 111220:
                return !lowerCase.equals(ChatTracker.CONTENT_PPT) ? 5 : 7;
            case 115312:
                return !lowerCase.equals("txt") ? 5 : 10;
            case 118783:
                return !lowerCase.equals("xls") ? 5 : 9;
            case 3088960:
                return !lowerCase.equals("docx") ? 5 : 8;
            case 3447940:
                return !lowerCase.equals("pptx") ? 5 : 7;
            case 3645337:
                return !lowerCase.equals("webm") ? 5 : 2;
            case 3682393:
                return !lowerCase.equals("xlsx") ? 5 : 9;
            case 246938863:
                return !lowerCase.equals("markdown") ? 5 : 11;
            default:
                return 5;
        }
    }
}
