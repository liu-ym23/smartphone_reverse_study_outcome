package com.tmall.wireless.tangram;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.collection.ArrayMap;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.bytedanceos.common.tangram.view.AppNavigationView;
import com.bytedanceos.common.tangram.view.TangramViewPagerItemView;
import com.tmall.wireless.tangram.core.service.ServiceManager;
import com.tmall.wireless.tangram.dataparser.concrete.Style;
import com.tmall.wireless.tangram.structure.BaseCell;
import com.tmall.wireless.tangram.structure.CellRender;
import com.tmall.wireless.tangram.structure.view.ITangramViewLifeCycle;
import com.tmall.wireless.tangram.support.CellSupport;
import com.tmall.wireless.tangram.support.ExposureSupport;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class MVHelper {
    private static final String TAG = "Tangram-MVHelper";
    private ArrayMap cellInitedMap;
    private MVResolver mMVResolver;
    private ArrayMap methodCacheMap;
    private ArrayMap methodMap;
    private ArrayMap postBindMap;
    private ArrayMap postUnBindMap;

    public MVHelper(MVResolver r10) {
        this.methodMap = new ArrayMap(128);
        this.methodCacheMap = new ArrayMap(128);
        this.postBindMap = new ArrayMap(128);
        this.postUnBindMap = new ArrayMap(128);
        this.cellInitedMap = new ArrayMap(128);
        this.mMVResolver = r10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void initView(BaseCell r10, View r11) {
        if ((r11 instanceof ITangramViewLifeCycle) == false) goto L6;
        ((ITangramViewLifeCycle) r11).cellInited(r10);
        return;
    L6:
        if (this.cellInitedMap.get(r10) == null) goto L15;
        ((Method) this.cellInitedMap.get(r10)).invoke(r11, new Object[]{r10});     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private void loadMethod(BaseCell r19, View r20) {
        MVHelper r10 = this;
        if ((r20 instanceof ITangramViewLifeCycle) == false) goto L6;
        return;
    L6:
        if (r10.methodMap.get(r19) == null) goto L8;
        return;
    L8:
        ArrayMap r11 = new ArrayMap();
        if (r10.methodCacheMap.get(r20.getClass()) != null) goto L11;
        Method[] r12 = r20.getClass().getDeclaredMethods();
        r10.methodCacheMap.put(r20.getClass(), r12);
    L12:
        int r13 = r12.length;
        int r14 = 0;
    L13:
        if (r14 >= r13) goto L147;
        Method r15 = r12[r14];
        CellRender r16 = (CellRender) r15.getAnnotation(CellRender.class);
        Class<?>[] r17 = r15.getParameterTypes();
        if (r15.isAnnotationPresent(CellRender.class) == false) goto L19;
        if (r17 == null) goto L19;
        if (r17.length != 1) goto L19;
        if (r15.getName().equals("postBindView") == false) goto L25;
        r10.postBindMap.put(r19, r15);
        goto L19
    L25:
        if (r15.getName().equals("postUnBindView") == false) goto L28;
        r10.postUnBindMap.put(r19, r15);
        goto L19
    L28:
        if (r15.getName().equals("cellInited") == false) goto L30;
        r10.cellInitedMap.put(r19, r15);
        goto L19
    L30:
        int r18 = r13;
        Method[] r110 = r12;
        if (TextUtils.isEmpty(r16.key()) == true) goto L73;
        if (r19.hasParam(r16.key()) == false) goto L73;
        if ("null".equals(r19.optParam(r16.key())) == false) goto L37;
        r11.put(r15, null);
    L145:
        r14 = r14 + 1;
        r10 = this;
        r13 = r18;
        r12 = r110;
        goto L13
    L37:
        boolean r21 = false;
        if (r17[0].equals(Integer.class) == false) goto L40;
    L71:
        r11.put(r15, Integer.valueOf(r19.optIntParam(r16.key())));
        goto L145
    L40:
        if (r17[0].equals(Integer.TYPE) == true) goto L71;
        if (r17[0].equals(String.class) == false) goto L47;
        r11.put(r15, r19.optStringParam(r16.key()));
        goto L145
    L47:
        if (r17[0].equals(Boolean.class) == false) goto L49;
    L70:
        r11.put(r15, Boolean.valueOf(r19.optBoolParam(r16.key())));
        goto L145
    L49:
        if (r17[0].equals(Boolean.TYPE) == true) goto L70;
        if (r17[0].equals(Double.class) == false) goto L54;
    L69:
        r11.put(r15, Double.valueOf(r19.optDoubleParam(r16.key())));
        goto L145
    L54:
        if (r17[0].equals(Double.TYPE) == true) goto L69;
        if (r17[0].equals(JSONArray.class) == false) goto L60;
        r11.put(r15, r19.optJsonArrayParam(r16.key()));
        goto L145
    L60:
        if (r17[0].equals(Long.class) == false) goto L62;
    L68:
        r11.put(r15, Long.valueOf(r19.optLongParam(r16.key())));
        goto L145
    L62:
        if (r17[0].equals(Long.TYPE) == true) goto L68;
        if (r17[0].equals(JSONObject.class) == false) goto L67;
        r11.put(r15, r19.optJsonObjectParam(r16.key()));
        goto L145
    L67:
        r11.put(r15, r19.optParam(r16.key()));
    L73:
        if (r19.hasParam(r15.getName()) == false) goto L112;
        if ("null".equals(r19.optParam(r15.getName())) == false) goto L77;
        r11.put(r15, null);
        goto L145
    L77:
        r21 = false;
        if (r17[0].equals(Integer.class) == false) goto L80;
    L110:
        r11.put(r15, Integer.valueOf(r19.optIntParam(r15.getName())));
        goto L145
    L80:
        if (r17[0].equals(Integer.TYPE) == true) goto L110;
        if (r17[0].equals(String.class) == false) goto L86;
        r11.put(r15, r19.optStringParam(r15.getName()));
        goto L145
    L86:
        if (r17[0].equals(Boolean.class) == false) goto L88;
    L109:
        r11.put(r15, Boolean.valueOf(r19.optBoolParam(r15.getName())));
        goto L145
    L88:
        if (r17[0].equals(Boolean.TYPE) == true) goto L109;
        if (r17[0].equals(Double.class) == false) goto L93;
    L108:
        r11.put(r15, Double.valueOf(r19.optDoubleParam(r15.getName())));
        goto L145
    L93:
        if (r17[0].equals(Double.TYPE) == true) goto L108;
        if (r17[0].equals(JSONArray.class) == false) goto L99;
        r11.put(r15, r19.optJsonArrayParam(r15.getName()));
        goto L145
    L99:
        if (r17[0].equals(Long.class) == false) goto L101;
    L107:
        r11.put(r15, Long.valueOf(r19.optLongParam(r15.getName())));
        goto L145
    L101:
        if (r17[0].equals(Long.TYPE) == true) goto L107;
        if (r17[0].equals(JSONObject.class) == false) goto L106;
        r11.put(r15, r19.optJsonObjectParam(r15.getName()));
        goto L145
    L106:
        r11.put(r15, r19.optParam(r15.getName()));
        goto L145
    L112:
        if (r17[0].equals(Integer.class) == false) goto L114;
    L144:
        r11.put(r15, 0);
        goto L145
    L114:
        if (r17[0].equals(Integer.TYPE) == true) goto L144;
        if (r17[0].equals(String.class) == false) goto L120;
        r11.put(r15, "");
        goto L145
    L120:
        if (r17[0].equals(Boolean.class) == false) goto L122;
    L143:
        r11.put(r15, Boolean.FALSE);
        goto L145
    L122:
        if (r17[0].equals(Boolean.TYPE) == true) goto L143;
        if (r17[0].equals(Double.class) == false) goto L127;
    L142:
        r11.put(r15, 0);
        goto L145
    L127:
        if (r17[0].equals(Double.TYPE) == true) goto L142;
        if (r17[0].equals(JSONArray.class) == false) goto L133;
        r11.put(r15, null);
        goto L145
    L133:
        if (r17[0].equals(Long.class) == false) goto L135;
    L141:
        r11.put(r15, 0);
        goto L145
    L135:
        if (r17[0].equals(Long.TYPE) == true) goto L141;
        if (r17[0].equals(JSONObject.class) == false) goto L140;
        r11.put(r15, null);
        goto L145
    L140:
        r11.put(r15, "");
    L19:
        r18 = r13;
        r110 = r12;
        goto L145
    L147:
        if (r11.isEmpty() == true) goto L161;
        this.methodMap.put(r19, r11);
        return;
    L161:
        return;
    L11:
        r12 = (Method[]) r10.methodCacheMap.get(r20.getClass());
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void postMountView(BaseCell r10, View r11) {
        if (r10.mIsExposed == true) goto L10;
        ServiceManager r12 = r10.serviceManager;
        if (r12 == null) goto L10;
        ExposureSupport r13 = (ExposureSupport) r12.getService(ExposureSupport.class);
        if (r13 == null) goto L10;
        r10.mIsExposed = true;
        r13.onExposure(r11, r10, r10.pos);
    L10:
        if ((r11 instanceof ITangramViewLifeCycle) == false) goto L13;
        ((ITangramViewLifeCycle) r11).postBindView(r10);
    L19:
        if (resolver().isCompatibleType(r10.type) == false) goto L24;
        resolver().getCellClass(r10.type).cast(r10).postBindView(r11);
        return;
    L24:
        return;
    L13:
        if (this.postBindMap.get(r10) == null) goto L19;
        ((Method) this.postBindMap.get(r10)).invoke(r11, new Object[]{r10});     // Catch: Exception -> L16
    L16:
        e = move-exception;
        e.printStackTrace();
        goto L19
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void postUnMountView(BaseCell r10, View r11) {
        if ((r11 instanceof ITangramViewLifeCycle) == false) goto L6;
        ((ITangramViewLifeCycle) r11).postUnBindView(r10);
        return;
    L6:
        if (this.postUnBindMap.get(r10) == null) goto L15;
        ((Method) this.postUnBindMap.get(r10)).invoke(r11, new Object[]{r10});     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    private void renderStyle(BaseCell r10, View r11) {
        renderLayout(r10, r11);
        renderBackground(r10, r11);
    }

    private void renderView(BaseCell r10, View r11) {
        if ((r11 instanceof ITangramViewLifeCycle) == false) goto L6;
        return;
    L6:
        if (this.methodMap.get(r10) != null) goto L8;
        return;
    L8:
        Iterator<Object> r12 = ((ArrayMap) this.methodMap.get(r10)).keySet().iterator();
    L10:
        if (r12.hasNext() == false) goto L16;
        Method r13 = (Method) r12.next();
        r13.invoke(r11, new Object[]{((ArrayMap) this.methodMap.get(r10)).get(r13)});     // Catch: Exception -> L14
    L14:
        e = move-exception;
        e.printStackTrace();
        goto L10
    }

    public boolean isValid(BaseCell r10, ServiceManager r11) {
        if (r11 == null) goto L13;
        CellSupport r12 = (CellSupport) r11.getService(CellSupport.class);
        if (r12 == null) goto L13;
        if (r12.isValid(r10) == true) goto L8;
    L10:
        return false;
    L8:
        if (r10.isValid() == false) goto L10;
        return true;
    L13:
        return r10.isValid();
    }

    public void mountView(BaseCell r10, View r11) {
        ServiceManager r12 = r10.serviceManager;     // Catch: Exception -> L8
        if (r12 == null) goto L10;
        CellSupport r13 = (CellSupport) r12.getService(CellSupport.class);     // Catch: Exception -> L8
        if (r13 == null) goto L10;
        r13.bindView(r10, r11);     // Catch: Exception -> L8
    L10:
        loadMethod(r10, r11);     // Catch: Exception -> L8
        initView(r10, r11);     // Catch: Exception -> L8
        renderView(r10, r11);     // Catch: Exception -> L8
        renderStyle(r10, r11);     // Catch: Exception -> L8
        if (resolver().isCompatibleType(r10.type) == false) goto L13;
        resolver().getCellClass(r10.type).cast(r10).bindView(r11);     // Catch: Exception -> L8
    L13:
        postMountView(r10, r11);     // Catch: Exception -> L8
        ServiceManager r14 = r10.serviceManager;     // Catch: Exception -> L8
        if (r14 == null) goto L27;
        CellSupport r15 = (CellSupport) r14.getService(CellSupport.class);     // Catch: Exception -> L8
        if (r15 == null) goto L28;
        r15.postBindView(r10, r11);     // Catch: Exception -> L8
        return;
    L28:
        return;
    L27:
        return;
    L8:
        e = move-exception;
        ServiceManager r16 = r10.serviceManager;
        if (r16 == null) goto L29;
        CellSupport r17 = (CellSupport) r16.getService(CellSupport.class);
        if (r17 == null) goto L30;
        r17.onBindViewException(r10, r11, e);
        return;
    L30:
        return;
    }

    public void parseCell(MVHelper r10, BaseCell r11, JSONObject r12) {
        this.mMVResolver.parseCell(r10, r11, r12);
    }

    public void renderBackground(BaseCell r10, View r11) {
        Style r12 = r10.style;
        if (r12 == null) goto L8;
        int r13 = r12.bgColor;
        if (r13 == 0) goto L9;
        r11.setBackgroundColor(r13);
        return;
    L9:
        return;
    }

    public void renderLayout(BaseCell r10, View r11) {
        if (r10.style == null) goto L35;
        ViewGroup.LayoutParams r12 = r11.getLayoutParams();
        if (r12 == null) goto L9;
        if ((r12 instanceof VirtualLayoutManager.LayoutParams) == false) goto L9;
    L14:
        if ((r12 instanceof VirtualLayoutManager.LayoutParams) == false) goto L24;
        VirtualLayoutManager.LayoutParams r13 = (VirtualLayoutManager.LayoutParams) r12;
        if (r10.style.height < 0) goto L18;
        r13.storeOriginHeight();
        ((ViewGroup.MarginLayoutParams) r13).height = r10.style.height;
    L20:
        if (r10.style.width < 0) goto L22;
        r13.storeOriginWidth();
        ((ViewGroup.MarginLayoutParams) r13).width = r10.style.width;
    L23:
        r13.mAspectRatio = r10.style.aspectRatio;
    L31:
        if ((r12 instanceof ViewGroup.MarginLayoutParams) == false) goto L33;
        ViewGroup.MarginLayoutParams r14 = (ViewGroup.MarginLayoutParams) r12;
        int[] r15 = r10.style.margin;
        r14.topMargin = r15[0];
        r14.leftMargin = r15[3];
        r14.bottomMargin = r15[2];
        r14.rightMargin = r15[1];
    L33:
        r11.setTranslationX(0.0f);
        r11.setTranslationY(0.0f);
        return;
    L22:
        r13.restoreOriginWidth();
        goto L23
    L18:
        r13.restoreOriginHeight();
        goto L20
    L24:
        Style r16 = r10.style;
        int r17 = r16.height;
        if (r17 < 0) goto L27;
        r12.height = r17;
    L27:
        int r18 = r16.width;
        if (r18 < 0) goto L31;
        r12.width = r18;
    L9:
        if ((r11 instanceof TangramViewPagerItemView) == true) goto L14;
        if ((r11 instanceof AppNavigationView) == true) goto L14;
        r12 = new VirtualLayoutManager.LayoutParams(-1, -1);
        r11.setLayoutParams(r12);
        goto L14
    }

    public void reset() {
        this.methodMap.clear();
        this.postBindMap.clear();
        this.postUnBindMap.clear();
        this.cellInitedMap.clear();
        this.mMVResolver.reset();
    }

    public MVResolver resolver() {
        return this.mMVResolver;
    }

    public void unMountView(BaseCell r10, View r11) {
        postUnMountView(r10, r11);
        ServiceManager r12 = r10.serviceManager;
        if (r12 == null) goto L8;
        CellSupport r13 = (CellSupport) r12.getService(CellSupport.class);
        if (r13 == null) goto L8;
        r13.unBindView(r10, r11);
    L8:
        if (resolver().isCompatibleType(r10.type) == false) goto L11;
        resolver().getCellClass(r10.type).cast(r10).unbindView(r11);
        return;
    }
}
