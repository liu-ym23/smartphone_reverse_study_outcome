package com.stepos.alphame.notification.Helpers;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.stepos.alphame.notification.model.TrainningParamsModel;
import com.stepos.alphame.utils.AlphaMeLogger;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes.dex */
public class DataHelper {
    public static TrainningParamsModel paramLoader(String str) throws IOException {
        TrainningParamsModel trainningParamsModel = new TrainningParamsModel();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(str)));
            JSONObject object = JSON.parseObject(bufferedReader.readLine());
            trainningParamsModel.setMaxSentenceLength(object.getInteger("maxSentenceLength").intValue());
            JSONObject jSONObject = object.getJSONObject("tags");
            String[] strArr = new String[jSONObject.keySet().size()];
            for (String str2 : jSONObject.keySet()) {
                strArr[vec2int((Integer[]) ((JSONArray) jSONObject.get(str2)).toArray(new Integer[0]))] = str2.toString();
            }
            trainningParamsModel.setTags(strArr);
            bufferedReader.close();
        } catch (Exception e4) {
            AlphaMeLogger.exceptionLog("paramLoader", e4);
        }
        return trainningParamsModel;
    }

    public static List<String> stopwordsLoader(String str) throws IOException {
        LinkedList linkedList = new LinkedList();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(str)));
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                linkedList.add(line);
            }
            bufferedReader.close();
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        return linkedList;
    }

    public static int vec2int(Integer[] numArr) {
        int i4 = 0;
        while (i4 < numArr.length && numArr[i4].intValue() != 1) {
            i4++;
        }
        return i4;
    }
}
