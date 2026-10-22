package com.stepos.aiengine.args;

import La.H;
import Y8.j;
import Z8.C1173v;
import Z8.M;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.core.data.FileContent;
import com.stepos.core.data.ImageContent;
import com.stepos.core.data.base.Content;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import v9.C5680i;
import v9.C5685n;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\t\b\u0016¢\u0006\u0004\b\u0004\u0010\u0006J\r\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\bJ\u001d\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/stepos/aiengine/args/MultiImageBundle;", "", "Landroid/os/Bundle;", "bundle", "<init>", "(Landroid/os/Bundle;)V", "()V", "toBundle", "()Landroid/os/Bundle;", "getBundle", "", "key", "Lcom/stepos/aiengine/args/SingleImageBundle;", "imageBundle", "put", "(Ljava/lang/String;Lcom/stepos/aiengine/args/SingleImageBundle;)Lcom/stepos/aiengine/args/MultiImageBundle;", Const.INTENT_KEY_APIKEY, "Landroid/os/Bundle;", "Companion", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MultiImageBundle {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String KEY_IMAGE_BITMAP_PREFIX = "image_bitmap_";
    public static final String KEY_IMAGE_COUNT = "image_count";
    public static final String KEY_IMAGE_PATH_PREFIX = "image_path_";

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Bundle bundle;

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\f\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u0004¢\u0006\u0004\b\f\u0010\tJ\u0015\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\u0015\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00140\u00130\u00042\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0015\u0010\u0012J\u0017\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u00058\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u00058\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001b\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\u00058\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001c\u0010\u001a¨\u0006\u001d"}, d2 = {"Lcom/stepos/aiengine/args/MultiImageBundle$Companion;", "", "<init>", "()V", "", "", "paths", "Lcom/stepos/aiengine/args/MultiImageBundle;", "fromPaths", "(Ljava/util/List;)Lcom/stepos/aiengine/args/MultiImageBundle;", "Landroid/graphics/Bitmap;", "bitmaps", "fromBitmaps", "Landroid/os/Bundle;", "bundle", "from", "(Landroid/os/Bundle;)Lcom/stepos/aiengine/args/MultiImageBundle;", "getPaths", "(Landroid/os/Bundle;)Ljava/util/List;", "Lkotlin/Pair;", "Lcom/stepos/core/data/base/Content;", "loadEmbeddingContents", "", Const.INTENT_KEY_APIKEY, "(Landroid/os/Bundle;)I", "KEY_IMAGE_COUNT", "Ljava/lang/String;", "KEY_IMAGE_PATH_PREFIX", "KEY_IMAGE_BITMAP_PREFIX", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final int a(Bundle bundle) {
            int i10 = 0;
            int i11 = bundle.getInt("image_count", 0);
            if (i11 > 0) {
                return i11;
            }
            while (true) {
                if (!bundle.containsKey(MultiImageBundle.KEY_IMAGE_PATH_PREFIX + i10)) {
                    if (!bundle.containsKey(MultiImageBundle.KEY_IMAGE_BITMAP_PREFIX + i10)) {
                        return i10;
                    }
                }
                i10++;
            }
        }

        public final MultiImageBundle from(Bundle bundle) {
            p.i(bundle, "bundle");
            return new MultiImageBundle(bundle, null);
        }

        public final MultiImageBundle fromBitmaps(List<Bitmap> bitmaps) {
            p.i(bitmaps, "bitmaps");
            Bundle bundle = new Bundle();
            bundle.putInt("image_count", bitmaps.size());
            int i10 = 0;
            for (Object obj : bitmaps) {
                int i11 = i10 + 1;
                if (i10 < 0) {
                    C1173v.w();
                }
                bundle.putParcelable(MultiImageBundle.KEY_IMAGE_BITMAP_PREFIX + i10, (Bitmap) obj);
                i10 = i11;
            }
            return new MultiImageBundle(bundle, null);
        }

        public final MultiImageBundle fromPaths(List<String> paths) {
            p.i(paths, "paths");
            Bundle bundle = new Bundle();
            bundle.putInt("image_count", paths.size());
            int i10 = 0;
            for (Object obj : paths) {
                int i11 = i10 + 1;
                if (i10 < 0) {
                    C1173v.w();
                }
                bundle.putString(MultiImageBundle.KEY_IMAGE_PATH_PREFIX + i10, (String) obj);
                i10 = i11;
            }
            return new MultiImageBundle(bundle, null);
        }

        public final List<String> getPaths(Bundle bundle) {
            p.i(bundle, "bundle");
            C5680i c5680iS = C5685n.s(0, bundle.getInt("image_count", 0));
            ArrayList arrayList = new ArrayList();
            Iterator<Integer> it = c5680iS.iterator();
            while (it.hasNext()) {
                String string = bundle.getString(MultiImageBundle.KEY_IMAGE_PATH_PREFIX + ((M) it).nextInt());
                if (string != null) {
                    arrayList.add(string);
                }
            }
            return arrayList;
        }

        public final List<Pair<String, Content>> loadEmbeddingContents(Bundle bundle) {
            String str;
            Object objB;
            p.i(bundle, "bundle");
            int iA = a(bundle);
            if (iA == 0) {
                return C1173v.m();
            }
            ArrayList arrayList = new ArrayList(iA);
            for (int i10 = 0; i10 < iA; i10++) {
                String string = bundle.getString(MultiImageBundle.KEY_IMAGE_PATH_PREFIX + i10);
                Bitmap bitmap = (Bitmap) bundle.getParcelable(MultiImageBundle.KEY_IMAGE_BITMAP_PREFIX + i10);
                String string2 = bundle.getString("embedding_id_" + i10);
                if (string2 != null) {
                    str = string2;
                } else if (string == null) {
                    string2 = "image_" + i10;
                    str = string2;
                } else {
                    str = string;
                }
                if (bitmap != null) {
                    arrayList.add(j.a(str, ImageContent.Companion.fromBitmap$default(ImageContent.INSTANCE, bitmap, 0, 0, 0, 0, 30, null)));
                } else if (string != null && !H.x0(string)) {
                    try {
                        Result.Companion companion = Result.INSTANCE;
                        objB = Result.b(BitmapFactory.decodeFile(string));
                    } catch (Throwable th) {
                        Result.Companion companion2 = Result.INSTANCE;
                        objB = Result.b(C4849c.a(th));
                    }
                    if (Result.g(objB)) {
                        objB = null;
                    }
                    Bitmap bitmap2 = (Bitmap) objB;
                    if (bitmap2 != null) {
                        try {
                            arrayList.add(j.a(str, ImageContent.Companion.fromBitmap$default(ImageContent.INSTANCE, bitmap2, 0, 0, 0, 0, 30, null)));
                        } finally {
                            bitmap2.recycle();
                        }
                    } else {
                        arrayList.add(j.a(str, new FileContent(string, null, null, 6, null)));
                    }
                }
            }
            return arrayList;
        }

        public Companion() {
        }
    }

    public /* synthetic */ MultiImageBundle(Bundle bundle, i iVar) {
        this(bundle);
    }

    public final Bundle getBundle() {
        return toBundle();
    }

    public final MultiImageBundle put(String key, SingleImageBundle imageBundle) {
        p.i(key, "key");
        p.i(imageBundle, "imageBundle");
        if (p.d(key, "image")) {
            key = "source";
        }
        this.bundle.putBundle(key, imageBundle.toBundle());
        return this;
    }

    public final Bundle toBundle() {
        return new Bundle(this.bundle);
    }

    public MultiImageBundle(Bundle bundle) {
        this.bundle = bundle;
    }

    public MultiImageBundle() {
        this(new Bundle());
    }
}
