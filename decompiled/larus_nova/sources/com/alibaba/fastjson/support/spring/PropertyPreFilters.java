package com.alibaba.fastjson.support.spring;

import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public class PropertyPreFilters {
    private List<MySimplePropertyPreFilter> filters;

    public class MySimplePropertyPreFilter extends SimplePropertyPreFilter {
        final /* synthetic */ PropertyPreFilters this$0;

        public MySimplePropertyPreFilter(PropertyPreFilters r100) {
            this.this$0 = r100;
            super(new String[0]);
        }

        public MySimplePropertyPreFilter addExcludes(String... r100) {
            int r101 = 0;
        L4:
            if (r101 >= r100.length) goto L6;
            getExcludes().add(r100[r101]);
            r101 = r101 + 1;
            goto L4
        L6:
            return this;
        }

        public MySimplePropertyPreFilter addIncludes(String... r100) {
            int r101 = 0;
        L4:
            if (r101 >= r100.length) goto L6;
            getIncludes().add(r100[r101]);
            r101 = r101 + 1;
            goto L4
        L6:
            return this;
        }

        public MySimplePropertyPreFilter(PropertyPreFilters r100, String... r101) {
            this.this$0 = r100;
            super(r101);
        }

        public MySimplePropertyPreFilter(PropertyPreFilters r100, Class<?> r101, String... r102) {
            this.this$0 = r100;
            super(r101, r102);
        }
    }

    public MySimplePropertyPreFilter addFilter() {
        MySimplePropertyPreFilter r100 = new MySimplePropertyPreFilter(this);
        this.filters.add(r100);
        return r100;
    }

    public MySimplePropertyPreFilter[] toFilters() {
        return (MySimplePropertyPreFilter[]) this.filters.toArray(new MySimplePropertyPreFilter[0]);
    }

    public PropertyPreFilters() {
        this.filters = new ArrayList();
    }

    public List<MySimplePropertyPreFilter> getFilters() {
        return this.filters;
    }

    public MySimplePropertyPreFilter addFilter(String... r100) {
        MySimplePropertyPreFilter r101 = new MySimplePropertyPreFilter(this, r100);
        this.filters.add(r101);
        return r101;
    }

    public void setFilters(List<MySimplePropertyPreFilter> r100) {
        this.filters = r100;
    }

    public MySimplePropertyPreFilter addFilter(Class<?> r100, String... r101) {
        MySimplePropertyPreFilter r102 = new MySimplePropertyPreFilter(this, r100, r101);
        this.filters.add(r102);
        return r102;
    }
}
