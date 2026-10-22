package ch5;

import com.bytedance.ee.bear.middleground.permission.collaborator.search.department.VisibleDepartment;
import com.bytedance.ee.bear.middleground.permission.collaborator.search.department.VisibleTopUserInDep;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.larksuite.framework.mvp.IModel;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes18.dex */
public interface e extends IModel {
    UserInfo K6(VisibleDepartment r100);

    VisibleDepartment M2(UserInfo r100);

    ArrayList<VisibleTopUserInDep> O1();

    void V7(VisibleDepartment r100, com.bytedance.ee.bear.middleground.permission.collaborator.search.department.d.c r101);

    UserInfo Y6(VisibleTopUserInDep r100);

    void i(UserInfo r100);

    void l(UserInfo r100);

    ArrayList<UserInfo> m0();

    void q6(d r100);

    ArrayList<VisibleDepartment> r6();

    void registerChangeListener(dh5.c r100);

    VisibleTopUserInDep u2(UserInfo r100);

    void unregisterChangeListener(dh5.c r100);
}
