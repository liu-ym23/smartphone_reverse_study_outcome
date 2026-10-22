package b6a;

import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.lynx.lottieadapter.AnimationType;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public interface b {
    <T> void addValueCallback(d6a.a r100, T r101, e6a.d<T> r102);

    void cancelAnimation();

    ColorFilter getColorFilter();

    c6a.c getComposition();

    AnimationType getContentType();

    long getDuration();

    int getFrame();

    String getImageAssetsFolder();

    float getMaxFrame();

    float getMinFrame();

    float getProgress();

    int getRepeatCount();

    int getRepeatMode();

    float getScale();

    float getSpeed();

    boolean isAnimating();

    void pauseAnimation();

    void playAnimation();

    void resumeAnimation();

    void setAnimation(int r100);

    void setAnimation(String r100);

    void setAnimation(JSONObject r100);

    void setAnimationFromJson(String r100);

    void setAnimationFromUrl(String r100);

    void setAutoPlay(boolean r100);

    void setColorFilter(ColorFilter r100);

    void setComposition(c6a.c r100);

    void setFontAssetDelegate(c6a.a r100);

    void setFrame(int r100);

    void setImageAssetDelegate(c6a.b r100);

    void setImageAssetsFolder(String r100);

    void setImageDrawable(Drawable r100);

    void setImageResource(int r100);

    void setMaxFrame(int r100);

    void setMaxFrameRate(float r100);

    void setMaxProgress(float r100);

    void setMinAndMaxProgress(float r100, float r101);

    void setMinFrame(int r100);

    void setMinProgress(float r100);

    void setOption(k r100);

    void setParentView(ViewGroup r100);

    void setProgress(float r100);

    void setRepeatCount(int r100);

    void setRepeatMode(int r100);

    void setScale(float r100);

    void setScaleType(ImageView.ScaleType r100);

    void setSpeed(float r100);
}
