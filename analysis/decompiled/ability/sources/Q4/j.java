package Q4;

import C7.r;
import S7.n;
import android.os.Bundle;
import com.stepos.aiengine.adapter.FaceEmbedAbilityAdapter;
import com.stepos.aiengine.adapter.FaceQualityAbilityAdapter;
import com.stepos.aiengine.args.result.FaceQualityResultBundle;
import com.stepos.core.data.TextContent;
import java.util.concurrent.CountDownLatch;
import kotlin.jvm.internal.Ref$ObjectRef;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final /* synthetic */ class j implements n {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1113a;
    public final /* synthetic */ Ref$ObjectRef b;
    public final /* synthetic */ CountDownLatch c;
    public final /* synthetic */ Object d;

    public /* synthetic */ j(Ref$ObjectRef ref$ObjectRef, Object obj, CountDownLatch countDownLatch, int i) {
        this.f1113a = i;
        this.b = ref$ObjectRef;
        this.d = obj;
        this.c = countDownLatch;
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        Bundle bundle;
        Bundle bundle2;
        switch (this.f1113a) {
            case 0:
                FaceEmbedAbilityAdapter faceEmbedAbilityAdapter = (FaceEmbedAbilityAdapter) this.d;
                TextContent r5 = (TextContent) obj2;
                kotlin.jvm.internal.k.f((String) obj, "<unused var>");
                kotlin.jvm.internal.k.f(r5, "r");
                String text = r5.getText();
                faceEmbedAbilityAdapter.getClass();
                try {
                    JSONObject jSONObject = new JSONObject(text);
                    if (kotlin.jvm.internal.k.b(jSONObject.optString("type"), "error")) {
                        bundle = new Bundle();
                        bundle.putString("exception", jSONObject.optString("message"));
                    } else {
                        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("features");
                        if (jSONArrayOptJSONArray == null) {
                            jSONArrayOptJSONArray = new JSONArray();
                        }
                        Bundle bundle3 = new Bundle();
                        bundle3.putInt("feature_count", jSONArrayOptJSONArray.length());
                        int length = jSONArrayOptJSONArray.length();
                        for (int i = 0; i < length; i++) {
                            JSONObject jSONObject2 = jSONArrayOptJSONArray.getJSONObject(i);
                            bundle3.putString("feature_" + i + "_token", jSONObject2.optString("token"));
                            bundle3.putInt("feature_" + i + "_dim", jSONObject2.optInt("dim"));
                            JSONArray jSONArrayOptJSONArray2 = jSONObject2.optJSONArray("feature");
                            if (jSONArrayOptJSONArray2 != null) {
                                int length2 = jSONArrayOptJSONArray2.length();
                                float[] fArr = new float[length2];
                                for (int i6 = 0; i6 < length2; i6++) {
                                    fArr[i6] = (float) jSONArrayOptJSONArray2.getDouble(i6);
                                }
                                bundle3.putFloatArray("feature_" + i + "_vector", fArr);
                            }
                            if (jSONObject2.has("quality")) {
                                bundle3.putFloat("feature_" + i + "_quality", (float) jSONObject2.getDouble("quality"));
                            }
                        }
                        bundle = bundle3;
                    }
                } catch (Exception e) {
                    Bundle bundle4 = new Bundle();
                    bundle4.putString("exception", "parse error: " + e.getMessage());
                    bundle = bundle4;
                }
                this.b.f4920a = bundle;
                this.c.countDown();
                break;
            default:
                FaceQualityAbilityAdapter faceQualityAbilityAdapter = (FaceQualityAbilityAdapter) this.d;
                TextContent r6 = (TextContent) obj2;
                kotlin.jvm.internal.k.f((String) obj, "<unused var>");
                kotlin.jvm.internal.k.f(r6, "r");
                String text2 = r6.getText();
                faceQualityAbilityAdapter.getClass();
                try {
                    JSONObject jSONObject3 = new JSONObject(text2);
                    if (kotlin.jvm.internal.k.b(jSONObject3.optString("type"), "error")) {
                        bundle2 = new Bundle();
                        bundle2.putString("exception", jSONObject3.optString("message"));
                    } else {
                        bundle2 = new Bundle();
                        bundle2.putFloat(FaceQualityResultBundle.KEY_QUALITY_SCORE, (float) jSONObject3.optDouble("quality", -1.0d));
                    }
                } catch (Exception e6) {
                    Bundle bundle5 = new Bundle();
                    bundle5.putString("exception", "parse error: " + e6.getMessage());
                    bundle2 = bundle5;
                }
                this.b.f4920a = bundle2;
                this.c.countDown();
                break;
        }
        return r.f317a;
    }
}
