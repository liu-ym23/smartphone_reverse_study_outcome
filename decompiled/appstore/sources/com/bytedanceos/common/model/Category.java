package com.bytedanceos.common.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class Category implements Serializable {
    private static final long serialVersionUID = -54564579191641686L;
    private List<Category> childCategories;
    private int child_id;
    private String icon;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f9836id;
    private String level;
    private String name;
    private Category parentCategory;
    private String parent_id;

    public Category() {
        this.childCategories = new ArrayList();
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if (r10 != null) goto L8;
    L17:
        return false;
    L8:
        if (getClass() != r10.getClass()) goto L17;
        Category r11 = (Category) r10;
        if (Objects.equals(this.f9836id, r11.f9836id) == false) goto L16;
        if (Objects.equals(this.name, r11.name) == false) goto L16;
        return true;
    L16:
        return false;
    }

    public List<Category> getChildCategories() {
        return this.childCategories;
    }

    public int getChild_id() {
        return this.child_id;
    }

    public String getIcon() {
        return this.icon;
    }

    public String getId() {
        return this.f9836id;
    }

    public String getLevel() {
        return this.level;
    }

    public String getName() {
        return this.name;
    }

    public Category getParentCategory() {
        return this.parentCategory;
    }

    public String getParent_id() {
        return this.parent_id;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.parentCategory, this.f9836id, this.name, this.parent_id, this.level, this.icon, this.childCategories});
    }

    public void setChildCategories(List<Category> r10) {
        this.childCategories = r10;
    }

    public void setChild_id(int r10) {
        this.child_id = r10;
    }

    public void setIcon(String r10) {
        this.icon = r10;
    }

    public void setId(String r10) {
        this.f9836id = r10;
    }

    public void setLevel(String r10) {
        this.level = r10;
    }

    public void setName(String r10) {
        this.name = r10;
    }

    public void setParentCategory(Category r10) {
        this.parentCategory = r10;
    }

    public void setParent_id(String r10) {
        this.parent_id = r10;
    }
}
