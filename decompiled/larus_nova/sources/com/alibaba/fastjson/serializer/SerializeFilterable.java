package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class SerializeFilterable {
    protected List<AfterFilter> afterFilters;
    protected List<BeforeFilter> beforeFilters;
    protected List<ContextValueFilter> contextValueFilters;
    protected List<LabelFilter> labelFilters;
    protected List<NameFilter> nameFilters;
    protected List<PropertyFilter> propertyFilters;
    protected List<PropertyPreFilter> propertyPreFilters;
    protected List<ValueFilter> valueFilters;
    protected boolean writeDirect;

    public List<AfterFilter> getAfterFilters() {
        if (this.afterFilters != null) goto L6;
        this.afterFilters = new ArrayList();
        this.writeDirect = false;
    L6:
        return this.afterFilters;
    }

    public List<BeforeFilter> getBeforeFilters() {
        if (this.beforeFilters != null) goto L6;
        this.beforeFilters = new ArrayList();
        this.writeDirect = false;
    L6:
        return this.beforeFilters;
    }

    public List<ContextValueFilter> getContextValueFilters() {
        if (this.contextValueFilters != null) goto L6;
        this.contextValueFilters = new ArrayList();
        this.writeDirect = false;
    L6:
        return this.contextValueFilters;
    }

    public List<LabelFilter> getLabelFilters() {
        if (this.labelFilters != null) goto L6;
        this.labelFilters = new ArrayList();
        this.writeDirect = false;
    L6:
        return this.labelFilters;
    }

    public List<NameFilter> getNameFilters() {
        if (this.nameFilters != null) goto L6;
        this.nameFilters = new ArrayList();
        this.writeDirect = false;
    L6:
        return this.nameFilters;
    }

    public List<PropertyFilter> getPropertyFilters() {
        if (this.propertyFilters != null) goto L6;
        this.propertyFilters = new ArrayList();
        this.writeDirect = false;
    L6:
        return this.propertyFilters;
    }

    public List<PropertyPreFilter> getPropertyPreFilters() {
        if (this.propertyPreFilters != null) goto L6;
        this.propertyPreFilters = new ArrayList();
        this.writeDirect = false;
    L6:
        return this.propertyPreFilters;
    }

    public List<ValueFilter> getValueFilters() {
        if (this.valueFilters != null) goto L6;
        this.valueFilters = new ArrayList();
        this.writeDirect = false;
    L6:
        return this.valueFilters;
    }

    public SerializeFilterable() {
        this.beforeFilters = null;
        this.afterFilters = null;
        this.propertyFilters = null;
        this.valueFilters = null;
        this.nameFilters = null;
        this.propertyPreFilters = null;
        this.labelFilters = null;
        this.contextValueFilters = null;
        this.writeDirect = true;
    }

    public void addFilter(SerializeFilter r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if ((r100 instanceof PropertyPreFilter) == false) goto L8;
        getPropertyPreFilters().add((PropertyPreFilter) r100);
    L8:
        if ((r100 instanceof NameFilter) == false) goto L11;
        getNameFilters().add((NameFilter) r100);
    L11:
        if ((r100 instanceof ValueFilter) == false) goto L14;
        getValueFilters().add((ValueFilter) r100);
    L14:
        if ((r100 instanceof ContextValueFilter) == false) goto L17;
        getContextValueFilters().add((ContextValueFilter) r100);
    L17:
        if ((r100 instanceof PropertyFilter) == false) goto L20;
        getPropertyFilters().add((PropertyFilter) r100);
    L20:
        if ((r100 instanceof BeforeFilter) == false) goto L23;
        getBeforeFilters().add((BeforeFilter) r100);
    L23:
        if ((r100 instanceof AfterFilter) == false) goto L26;
        getAfterFilters().add((AfterFilter) r100);
    L26:
        if ((r100 instanceof LabelFilter) == false) goto L29;
        getLabelFilters().add((LabelFilter) r100);
        return;
    }

    public boolean writeDirect(JSONSerializer r100) {
        if (r100.out.writeDirect == true) goto L5;
    L9:
        return false;
    L5:
        if (this.writeDirect == false) goto L9;
        if (r100.writeDirect == false) goto L9;
        return true;
    }

    public boolean applyName(JSONSerializer r100, Object r101, String r102) {
        List<PropertyPreFilter> r103 = r100.propertyPreFilters;
        if (r103 == null) goto L10;
        Iterator<PropertyPreFilter> r104 = r103.iterator();
    L6:
        if (r104.hasNext() == false) goto L10;
        if (r104.next().apply(r100, r101, r102) == true) goto L6;
        return false;
    L10:
        List<PropertyPreFilter> r105 = this.propertyPreFilters;
        if (r105 == null) goto L18;
        Iterator<PropertyPreFilter> r106 = r105.iterator();
    L14:
        if (r106.hasNext() == false) goto L26;
        if (r106.next().apply(r100, r101, r102) == true) goto L14;
        return false;
    L26:
        return true;
    L18:
        return true;
    }

    public boolean apply(JSONSerializer r100, Object r101, String r102, Object r103) {
        List<PropertyFilter> r104 = r100.propertyFilters;
        if (r104 == null) goto L10;
        Iterator<PropertyFilter> r105 = r104.iterator();
    L6:
        if (r105.hasNext() == false) goto L10;
        if (r105.next().apply(r101, r102, r103) == true) goto L6;
        return false;
    L10:
        List<PropertyFilter> r106 = this.propertyFilters;
        if (r106 == null) goto L18;
        Iterator<PropertyFilter> r107 = r106.iterator();
    L14:
        if (r107.hasNext() == false) goto L26;
        if (r107.next().apply(r101, r102, r103) == true) goto L14;
        return false;
    L26:
        return true;
    L18:
        return true;
    }

    public String processKey(JSONSerializer r100, Object r101, String r102, Object r103) {
        List<NameFilter> r104 = r100.nameFilters;
        if (r104 == null) goto L8;
        Iterator<NameFilter> r105 = r104.iterator();
    L6:
        if (r105.hasNext() == false) goto L8;
        r102 = r105.next().process(r101, r102, r103);
    L8:
        List<NameFilter> r106 = this.nameFilters;
        if (r106 == null) goto L14;
        Iterator<NameFilter> r107 = r106.iterator();
    L12:
        if (r107.hasNext() == false) goto L14;
        r102 = r107.next().process(r101, r102, r103);
    L14:
        return r102;
    }

    public Object processValue(JSONSerializer r100, BeanContext r101, Object r110, String r111, Object r112) {
        return processValue(r100, r101, r110, r111, r112, 0);
    }

    public Object processValue(JSONSerializer r100, BeanContext r101, Object r102, String r103, Object r104, int r105) {
        if (r104 == null) goto L24;
        int r106 = r100.out.features;
        SerializerFeature r107 = SerializerFeature.WriteNonStringValueAsString;
        if (SerializerFeature.isEnabled(r106, r105, r107) == true) goto L8;
        if (r101 != null) goto L7;
    L13:
        if (r101 == null) goto L24;
        if (r101.isJsonDirect() == false) goto L24;
        r104 = JSON.parse((String) r104);
        goto L24
    L7:
        if ((r101.getFeatures() & r107.mask) == 0) goto L13;
    L8:
        boolean r108 = r104 instanceof Number;
        if (r108 == false) goto L11;
    L17:
        if (r108 == false) goto L20;
        if (r101 == null) goto L20;
        String r109 = r101.getFormat();
    L21:
        if (r109 == null) goto L23;
        r104 = new DecimalFormat(r109).format(r104);
        goto L24
    L23:
        r104 = r104.toString();
    L20:
        r109 = null;
        goto L21
    L11:
        if ((r104 instanceof Boolean) == false) goto L13;
    L24:
        List<ValueFilter> r110 = r100.valueFilters;
        if (r110 == null) goto L30;
        Iterator<ValueFilter> r111 = r110.iterator();
    L28:
        if (r111.hasNext() == false) goto L30;
        r104 = r111.next().process(r102, r103, r104);
    L30:
        List<ValueFilter> r112 = this.valueFilters;
        if (r112 == null) goto L36;
        Iterator<ValueFilter> r113 = r112.iterator();
    L34:
        if (r113.hasNext() == false) goto L36;
        r104 = r113.next().process(r102, r103, r104);
    L36:
        List<ContextValueFilter> r114 = r100.contextValueFilters;
        if (r114 == null) goto L42;
        Iterator<ContextValueFilter> r115 = r114.iterator();
    L40:
        if (r115.hasNext() == false) goto L42;
        r104 = r115.next().process(r101, r102, r103, r104);
    L42:
        List<ContextValueFilter> r116 = this.contextValueFilters;
        if (r116 == null) goto L48;
        Iterator<ContextValueFilter> r117 = r116.iterator();
    L46:
        if (r117.hasNext() == false) goto L48;
        r104 = r117.next().process(r101, r102, r103, r104);
    L48:
        return r104;
    }
}
