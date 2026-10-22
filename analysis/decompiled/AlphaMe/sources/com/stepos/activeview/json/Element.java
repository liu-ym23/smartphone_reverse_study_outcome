package com.stepos.activeview.json;

import android.content.Context;
import android.graphics.Color;
import com.stepos.activeview.databinding.model.DataBindingJson;
import com.stepos.activeview.utils.DisplayUnitUtil;
import java.util.List;

/* loaded from: classes.dex */
public class Element {
    private static final int DOM_2D_ARRAY_LENGTH = 2;
    private static final int DOM_3D_ARRAY_LENGTH = 3;
    private static final int DOM_RECT_ARRAY_LENGTH = 4;
    private static final String LOG_TAG = "Parse_Element";
    List<Animation> animations;
    private ApertureData aperture;
    private String background;
    private Float blur;
    private DataBindingJson dataBinding;
    private List<Element> elements;
    List<Event> events;
    private String hover;
    private String id;
    private String jsonPath;
    LayerAni layerAni;
    private Integer mBackgroundColorValue;
    private float mRadiusValue;
    private Integer opacity;
    Orientation orientation;
    Parallax parallax;
    private Particle2DAttr particle2DAttr;
    private String radius;
    private String[] rect;
    private SeekBarAttrs seekBarAttrs;
    private StatesButtonAttrs statesButtonAttrs;
    private TextAttrs textAttrs;
    private String type;
    String url;
    private VideoAttr videoAttr;
    private WaveData wave;
    private float[] mRectRegion = new float[4];
    private float[] scale2d = new float[2];
    private float[] rotate3d = new float[3];
    private String[] rotateCenter = new String[2];
    private float[] rotateCenterValue = new float[2];

    public List<Animation> getAnimations() {
        return this.animations;
    }

    public ApertureData getAperture() {
        return this.aperture;
    }

    public String getBackground() {
        return this.background;
    }

    public Integer getBackgroundColorValue() {
        String str = this.background;
        if (str != null && !str.isEmpty()) {
            this.mBackgroundColorValue = Integer.valueOf(Color.parseColor(this.background));
        }
        return this.mBackgroundColorValue;
    }

    public Float getBlur() {
        return this.blur;
    }

    public DataBindingJson getDataBinding() {
        return this.dataBinding;
    }

    public List<Element> getElements() {
        return this.elements;
    }

    public List<Event> getEvents() {
        return this.events;
    }

    public String getHover() {
        return this.hover;
    }

    public String getId() {
        return this.id;
    }

    public String getJsonPath() {
        return this.jsonPath;
    }

    public LayerAni getLayerAni() {
        return this.layerAni;
    }

    public Integer getOpacity() {
        return this.opacity;
    }

    public Orientation getOrientation() {
        return this.orientation;
    }

    public Parallax getParallax() {
        return this.parallax;
    }

    public Particle2DAttr getParticle2DAttr() {
        return this.particle2DAttr;
    }

    public String getRadius() {
        return this.radius;
    }

    public float getRadiusValue(Context context) {
        String str = this.radius;
        if (str != null && !str.isEmpty()) {
            this.mRadiusValue = DisplayUnitUtil.getPixelValue(context, this.radius);
        }
        return this.mRadiusValue;
    }

    public String[] getRect() {
        return this.rect;
    }

    public float[] getRectRegion(Context context) {
        float[] fArr;
        String[] strArr = this.rect;
        if (strArr != null && strArr.length == 4 && (fArr = this.mRectRegion) != null && fArr.length == 4) {
            for (int i4 = 0; i4 < 4; i4++) {
                if (this.rect[i4] != null) {
                    this.mRectRegion[i4] = DisplayUnitUtil.getPixelValue(context, r2);
                }
            }
        }
        return this.mRectRegion;
    }

    public float[] getRotate3d() {
        return this.rotate3d;
    }

    public String[] getRotateCenter() {
        return this.rotateCenter;
    }

    public float[] getRotateCenterValue(Context context) {
        String[] strArr = this.rotateCenter;
        if (strArr != null && strArr.length == 2) {
            for (int i4 = 0; i4 < 2; i4++) {
                if (this.rotateCenter[i4] != null) {
                    this.rotateCenterValue[i4] = DisplayUnitUtil.getPixelValue(context, r2);
                }
            }
        }
        return this.rotateCenterValue;
    }

    public float[] getScale2d() {
        return this.scale2d;
    }

    public SeekBarAttrs getSeekBarAttrs() {
        return this.seekBarAttrs;
    }

    public StatesButtonAttrs getStatesButtonAttrs() {
        return this.statesButtonAttrs;
    }

    public TextAttrs getTextAttrs() {
        return this.textAttrs;
    }

    public String getType() {
        return this.type;
    }

    public String getUrl() {
        return this.url;
    }

    public VideoAttr getVideoAttr() {
        return this.videoAttr;
    }

    public WaveData getWave() {
        return this.wave;
    }

    public void setAnimations(List<Animation> list) {
        this.animations = list;
    }

    public void setAperture(ApertureData apertureData) {
        this.aperture = apertureData;
    }

    public void setBackground(String str) {
        this.background = str;
    }

    public void setBlur(Float f4) {
        this.blur = f4;
    }

    public void setDataBinding(DataBindingJson dataBindingJson) {
        this.dataBinding = dataBindingJson;
    }

    public void setElements(List<Element> list) {
        this.elements = list;
    }

    public void setEvents(List<Event> list) {
        this.events = list;
    }

    public void setHover(String str) {
        this.hover = str;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setJsonPath(String str) {
        this.jsonPath = str;
    }

    public void setLayerAni(LayerAni layerAni) {
        this.layerAni = layerAni;
    }

    public void setOpacity(Integer num) {
        this.opacity = num;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    public void setParallax(Parallax parallax) {
        this.parallax = parallax;
    }

    public void setParticle2DAttr(Particle2DAttr particle2DAttr) {
        this.particle2DAttr = particle2DAttr;
    }

    public void setRadius(String str) {
        this.radius = str;
    }

    public void setRect(String[] strArr) {
        this.rect = strArr;
    }

    public void setRotate3d(float[] fArr) {
        if (fArr.length != 3) {
            return;
        }
        this.rotate3d = fArr;
    }

    public void setRotateCenter(String[] strArr) {
        if (strArr.length != 2) {
            return;
        }
        this.rotateCenter = strArr;
    }

    public void setScale2d(float[] fArr) {
        if (fArr.length != 2) {
            return;
        }
        this.scale2d = fArr;
    }

    public void setSeekBarAttrs(SeekBarAttrs seekBarAttrs) {
        this.seekBarAttrs = seekBarAttrs;
    }

    public void setStatesButtonAttrs(StatesButtonAttrs statesButtonAttrs) {
        this.statesButtonAttrs = statesButtonAttrs;
    }

    public void setTextAttrs(TextAttrs textAttrs) {
        this.textAttrs = textAttrs;
    }

    public void setType(String str) {
        this.type = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public void setVideoAttr(VideoAttr videoAttr) {
        this.videoAttr = videoAttr;
    }

    public void setWave(WaveData waveData) {
        this.wave = waveData;
    }
}
