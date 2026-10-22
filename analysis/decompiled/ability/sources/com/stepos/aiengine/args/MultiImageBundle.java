package com.stepos.aiengine.args;

import B7.a;
import D7.F;
import H4.o;
import Y7.f;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import com.stepos.core.data.FileContent;
import com.stepos.core.data.ImageContent;
import com.stepos.core.data.base.Content;
import d5.n;
import g1.AbstractC1451a;
import j9.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.b;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\u0006J\u001d\u0010\f\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lcom/stepos/aiengine/args/MultiImageBundle;", "", AppAgent.CONSTRUCT, "()V", "Landroid/os/Bundle;", "toBundle", "()Landroid/os/Bundle;", "getBundle", "", "key", "Lcom/stepos/aiengine/args/SingleImageBundle;", "imageBundle", "put", "(Ljava/lang/String;Lcom/stepos/aiengine/args/SingleImageBundle;)Lcom/stepos/aiengine/args/MultiImageBundle;", "Companion", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class MultiImageBundle {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String KEY_IMAGE_BITMAP_PREFIX = "image_bitmap_";
    public static final String KEY_IMAGE_COUNT = "image_count";
    public static final String KEY_IMAGE_PATH_PREFIX = "image_path_";

    /* renamed from: a, reason: collision with root package name */
    public final Bundle f3493a;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001J\u001b\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\n\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0002¢\u0006\u0004\b\n\u0010\u0007J\u0015\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\u0013\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00120\u00110\u00022\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0013\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u00038\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00038\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00038\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/stepos/aiengine/args/MultiImageBundle$Companion;", "", "", "", "paths", "Lcom/stepos/aiengine/args/MultiImageBundle;", "fromPaths", "(Ljava/util/List;)Lcom/stepos/aiengine/args/MultiImageBundle;", "Landroid/graphics/Bitmap;", "bitmaps", "fromBitmaps", "Landroid/os/Bundle;", "bundle", TypedValues.TransitionType.S_FROM, "(Landroid/os/Bundle;)Lcom/stepos/aiengine/args/MultiImageBundle;", "getPaths", "(Landroid/os/Bundle;)Ljava/util/List;", "Lkotlin/Pair;", "Lcom/stepos/core/data/base/Content;", "loadEmbeddingContents", "KEY_IMAGE_COUNT", "Ljava/lang/String;", "KEY_IMAGE_PATH_PREFIX", "KEY_IMAGE_BITMAP_PREFIX", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public Companion(e eVar) {
        }

        public final MultiImageBundle from(Bundle bundle) {
            k.f(bundle, "bundle");
            return new MultiImageBundle(bundle, null);
        }

        public final MultiImageBundle fromBitmaps(List<Bitmap> bitmaps) {
            k.f(bitmaps, "bitmaps");
            Bundle bundle = new Bundle();
            bundle.putInt("image_count", bitmaps.size());
            Iterator<T> it = bitmaps.iterator();
            int i = 0;
            while (true) {
                e eVar = null;
                if (!it.hasNext()) {
                    return new MultiImageBundle(bundle, eVar);
                }
                Object next = it.next();
                int i6 = i + 1;
                if (i < 0) {
                    o.X();
                    throw null;
                }
                bundle.putParcelable(MultiImageBundle.KEY_IMAGE_BITMAP_PREFIX + i, (Bitmap) next);
                i = i6;
            }
        }

        public final MultiImageBundle fromPaths(List<String> paths) {
            k.f(paths, "paths");
            Bundle bundle = new Bundle();
            bundle.putInt("image_count", paths.size());
            Iterator<T> it = paths.iterator();
            int i = 0;
            while (true) {
                e eVar = null;
                if (!it.hasNext()) {
                    return new MultiImageBundle(bundle, eVar);
                }
                Object next = it.next();
                int i6 = i + 1;
                if (i < 0) {
                    o.X();
                    throw null;
                }
                bundle.putString(MultiImageBundle.KEY_IMAGE_PATH_PREFIX + i, (String) next);
                i = i6;
            }
        }

        public final List<String> getPaths(Bundle bundle) {
            k.f(bundle, "bundle");
            f fVarX = AbstractC1451a.X(0, bundle.getInt("image_count", 0));
            ArrayList arrayList = new ArrayList();
            Iterator it = fVarX.iterator();
            while (it.hasNext()) {
                String string = bundle.getString(MultiImageBundle.KEY_IMAGE_PATH_PREFIX + ((F) it).nextInt());
                if (string != null) {
                    arrayList.add(string);
                }
            }
            return arrayList;
        }

        public final List<Pair<String, Content>> loadEmbeddingContents(Bundle bundle) {
            String str;
            Object objA;
            k.f(bundle, "bundle");
            int i = bundle.getInt("image_count", 0);
            if (i <= 0) {
                i = 0;
                while (true) {
                    if (!bundle.containsKey(MultiImageBundle.KEY_IMAGE_PATH_PREFIX + i)) {
                        if (!bundle.containsKey(MultiImageBundle.KEY_IMAGE_BITMAP_PREFIX + i)) {
                            break;
                        }
                    }
                    i++;
                }
            }
            int i6 = i;
            if (i6 == 0) {
                return EmptyList.f4893a;
            }
            ArrayList arrayList = new ArrayList(i6);
            for (int i10 = 0; i10 < i6; i10++) {
                String string = bundle.getString(MultiImageBundle.KEY_IMAGE_PATH_PREFIX + i10);
                Bitmap bitmap = (Bitmap) bundle.getParcelable(MultiImageBundle.KEY_IMAGE_BITMAP_PREFIX + i10);
                String string2 = bundle.getString("embedding_id_" + i10);
                if (string2 != null) {
                    str = string2;
                } else if (string == null) {
                    string2 = a.h(i10, "image_");
                    str = string2;
                } else {
                    str = string;
                }
                if (bitmap != null) {
                    arrayList.add(new Pair(str, n.b(ImageContent.Companion, bitmap, 0, 0, 0, 0, 30)));
                } else if (string != null && !m.s0(string)) {
                    try {
                        objA = BitmapFactory.decodeFile(string);
                    } catch (Throwable th) {
                        objA = b.a(th);
                    }
                    if (objA instanceof Result.Failure) {
                        objA = null;
                    }
                    Bitmap bitmap2 = (Bitmap) objA;
                    if (bitmap2 != null) {
                        try {
                            arrayList.add(new Pair(str, n.b(ImageContent.Companion, bitmap2, 0, 0, 0, 0, 30)));
                        } finally {
                            bitmap2.recycle();
                        }
                    } else {
                        arrayList.add(new Pair(str, new FileContent(string, null, null, 6, null)));
                    }
                }
            }
            return arrayList;
        }
    }

    public /* synthetic */ MultiImageBundle(Bundle bundle, e eVar) {
        this(bundle);
    }

    public final Bundle getBundle() {
        return toBundle();
    }

    public final MultiImageBundle put(String key, SingleImageBundle imageBundle) {
        k.f(key, "key");
        k.f(imageBundle, "imageBundle");
        if (key.equals("image")) {
            key = AgentBusWakeContract.EXTRA_SOURCE;
        }
        this.f3493a.putBundle(key, imageBundle.toBundle());
        return this;
    }

    public final Bundle toBundle() {
        return new Bundle(this.f3493a);
    }

    public MultiImageBundle(Bundle bundle) {
        this.f3493a = bundle;
    }

    public MultiImageBundle() {
        this(new Bundle());
    }
}
